package com.example.orderattack.game.kiosk;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;

import com.bumptech.glide.Glide;
import com.example.orderattack.R;
import com.example.orderattack.databinding.ActivityKioskBonusAiBinding;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;
import com.googlecode.tesseract.android.TessBaseAPI;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class KioskBonusAiActivity extends AppCompatActivity {

    private ActivityKioskBonusAiBinding binding;
    private FirebaseStorage storage;
    private TessBaseAPI tessBaseAPI;
    public String result = "";
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PERMISSION_REQUEST_STORAGE = 2;
    private AlertDialog loadingDialog;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한이 허가되었습니다.
            } else {
                // 권한이 거부되었습니다.
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKioskBonusAiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storage = FirebaseStorage.getInstance();

        initOCR();

        // 버튼 클릭 시 이미지 가져오기
        // StorageReference photoRef = storage.getReference("m1.jpg");
        // File localFile = new File(getFilesDir(), "m1.jpg");
        binding.bonusUploadButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                // getContentResolver를 사용하여 Uri로부터 Bitmap을 생성합니다.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);

                // 노이즈 제거와 대비 및 밝기 조정을 수행합니다.
                bitmap = removeNoise(this, bitmap, 2.0f);
                bitmap = adjustContrastAndBrightness(bitmap, 5, 5);

                // 최종 처리된 이미지를 사용합니다. 예: 이미지 뷰에 표시
                binding.imageView.setImageBitmap(bitmap);

                // 선택한 이미지를 Firebase Storage에 업로드합니다.
                uploadImageToFirebaseStorage(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void uploadImageToFirebaseStorage(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        String path = "images/" + UUID.randomUUID() + ".jpg";
        StorageReference imageRef = storage.getReference(path);

        UploadTask uploadTask = imageRef.putBytes(data);
        uploadTask.addOnFailureListener(e -> {
            // 업로드 실패 처리
            Log.d("image", "upload failed: " + e.getMessage());
        }).addOnSuccessListener(taskSnapshot -> {
            // 업로드 성공 처리, 다운로드 URL 가져오기
            Log.d("image", "upload success");
            imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                // 이미지 다운로드 URL 사용, 예: OCR 처리 또는 이미지 뷰에 표시
                Log.d("image", "download URL: " + uri.toString());
                downloadAndProcessImage(uri.toString());
            });
        });
    }

    private void downloadAndProcessImage(String imagePath) {
        showLoadingPopup();
        StorageReference photoRef = storage.getReferenceFromUrl(imagePath);
        final File localFile = new File(getFilesDir(), "downloadedImage.jpg");

        photoRef.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
            // 이미지 다운로드 성공
            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());

            // 이미지 방향에 맞게 비트맵 회전
            int orientation = getOrientationOfImage(localFile.getAbsolutePath());
            if (orientation != -1) {
                bitmap = getRotatedBitmap(bitmap, orientation);
            }

            // 노이즈 제거 및 대비 및 밝기 조정
            bitmap = removeNoise(KioskBonusAiActivity.this, bitmap, 2.0f);
            bitmap = adjustContrastAndBrightness(bitmap, 5, 5);

            // OCR 처리
            processImage(bitmap, text -> {
                // OCR 처리 결과를 사용하여 NLP 분석 수행
                result = text; // processImage 메서드에서 반환된 텍스트를 전역 변수 result에 저장
                nlpBert(); // NLP 분석을 수행하는 메서드 호출
            });

        }).addOnFailureListener(e -> {
            // 이미지 다운로드 실패 처리
            Log.e(TAG, "Failed to download image for OCR processing", e);
        });
    }



    // 학습 데이터 및 초기화 함수
    private void initOCR() {
        String language = "kor+eng";

            // 학습 데이터 폴더 경로
        String dataPath = getFilesDir() + "/tessdata/";
        File dataDir = new File(dataPath);

            // 폴더 생성
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        copyFiles(dataPath);

        tessBaseAPI = new TessBaseAPI();
        tessBaseAPI.init(getFilesDir().getAbsolutePath(), language);
    }


        // 문자 인식 및 결과 출력
    public void processImage(Bitmap bitmap, ResultListener resultListener) {
        Toast.makeText(getApplicationContext(), "이미지가 복잡할 경우 해석 시 많은 시간이 소요될 수도 있습니다.", Toast.LENGTH_LONG).show();
        new Thread(() -> {
            tessBaseAPI.setImage(bitmap);
            result = tessBaseAPI.getUTF8Text();

            new Handler(Looper.getMainLooper()).post(() -> {
                resultListener.onResult(result);
            });
        }).start();
    }

    // assets 폴더에 있는 학습 데이터를 내부 저장소에 복사
    private void copyFiles(String dataDir) {
        try {
            AssetManager assetManager = getAssets();
            String[] fileList = assetManager.list("tessdata");

            for (String fileName : fileList) {
                String path = dataDir + fileName;
                File file = new File(path);

                if (!file.exists()) {
                    try (
                            InputStream inStream = assetManager.open("tessdata/" + fileName);
                            OutputStream outStream = new FileOutputStream(file)
                    ) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inStream.read(buffer)) != -1) {
                                outStream.write(buffer, 0, length);
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getOrientationOfImage(String filepath) {
        ExifInterface exif = null;

        try {
            exif = new ExifInterface(filepath);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);

        if (orientation != -1) {
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return 90;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return 180;

                case ExifInterface.ORIENTATION_ROTATE_270:
                    return 270;
            }
        }

        return 0;
    }

    public Bitmap getRotatedBitmap(Bitmap bitmap, int degrees) {
        if (bitmap == null) return null;
        if (degrees == 0) return bitmap;

        Matrix m = new Matrix();
        m.setRotate(degrees, (float) bitmap.getWidth() / 2, (float) bitmap.getHeight() / 2);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
    }

    @FunctionalInterface
    public interface ResultListener {
        void onResult(String text);
    }

    public void nlpBert() {
        TextView statusTextView = findViewById(R.id.Result_TextView);

        FirebaseLanguageIdentification languageIdentifier =
                FirebaseNaturalLanguage.getInstance().getLanguageIdentification();
        languageIdentifier.identifyLanguage(result)
                .addOnSuccessListener(languageCode -> {
                    if (!"und".equals(languageCode)) {
                        // 주어진 문장에서 "제품", "주문", "카운터" 단어가 있는지 확인
                        if (result.contains("제품") || result.contains("주문") || result.contains("카운터")) {
                            // 특정 단어를 찾았을 때
                            runOnUiThread(() -> {
                                statusTextView.setText("Success");
                                showSuccessPopup(); // 성공 팝업창 표시
                            });
                        } else {
                            // 특정 단어를 찾지 못했을 때
                            runOnUiThread(() -> statusTextView.setText("Failure"));
                        }
                    } else {
                        Log.i(TAG, "Can't identify language.");
                    }
                })
                .addOnFailureListener(e -> {
                    // 모델을 로드하지 못하거나 다른 내부 오류 발생
                    Log.e(TAG, "Language identification failed", e);
                });
    }

    private void showLoadingPopup() {
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.popup_loading, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);
        builder.setCancelable(false); // 팝업창을 밖의 영역을 터치해도 닫히지 않도록 설정

        loadingDialog = builder.create();

        // 팝업창 배경을 투명하게 설정
        if (loadingDialog.getWindow() != null) {
            loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        loadingDialog.show();
    }


    private void showSuccessPopup() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.popup_success, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);

        AlertDialog dialog = builder.create();

        // 팝업창 배경을 투명하게 설정합니다.
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        dialog.setOnDismissListener(dialogInterface -> {
            // 팝업창이 닫히면 KioskSuccessBonusActivity로 이동합니다.
            Intent intent = new Intent(KioskBonusAiActivity.this, KioskSuccessBonusActivity.class);
            startActivity(intent);
        });

        dialog.show();

        // 팝업창을 터치하면 자동으로 닫히도록 설정합니다.
        popupView.setOnClickListener(v -> dialog.dismiss());
    }



    //여기 아래는 전처리 removeNoise는 노이즈 삭제. 뿌옇게 만들어줌.
    //adjustContrastAndBrightness는 대비 주는 것. ui 사진에서는 대비를 안주는 것처럼 나오는게 나을것같다. 실제로는 대비를 해야 결과가 잘나옴.
    public Bitmap removeNoise(Context context, Bitmap bitmap, float radius) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        RenderScript rs = RenderScript.create(context);
        Allocation input = Allocation.createFromBitmap(rs, bitmap);
        Allocation outputAlloc = Allocation.createTyped(rs, input.getType());

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        blur.setInput(input);
        blur.setRadius(radius);
        blur.forEach(outputAlloc);

        outputAlloc.copyTo(output);
        rs.destroy();

        return output;
    }

    public Bitmap adjustContrastAndBrightness(Bitmap bitmap, float contrast, float brightness) {
        Bitmap adjustedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];
            int alpha = (pixel >> 24) & 0xFF;
            int red = (pixel >> 16) & 0xFF;
            int green = (pixel >> 8) & 0xFF;
            int blue = pixel & 0xFF;

                // Adjust contrast
            red = (int) (contrast * (red - 128) + 128);
            green = (int) (contrast * (green - 128) + 128);
            blue = (int) (contrast * (blue - 128) + 128);

                // Adjust brightness
            red += brightness;
            green += brightness;
            blue += brightness;

                // Clamp values to [0, 255]
            red = Math.max(0, Math.min(255, red));
            green = Math.max(0, Math.min(255, green));
            blue = Math.max(0, Math.min(255, blue));

            pixels[i] = (alpha << 24) | (red << 16) | (green << 8) | blue;
            }

        adjustedBitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        return adjustedBitmap;
    }
}


