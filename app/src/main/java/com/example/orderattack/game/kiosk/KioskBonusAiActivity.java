package com.example.orderattack.game.kiosk;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;

import com.example.orderattack.R;
import com.example.orderattack.databinding.ActivityKioskBonusAiBinding;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;
import com.googlecode.tesseract.android.TessBaseAPI;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class KioskBonusAiActivity extends AppCompatActivity {

    private ActivityKioskBonusAiBinding binding;
    private FirebaseStorage storage;
    private TessBaseAPI tessBaseAPI;
    public String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKioskBonusAiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storage = FirebaseStorage.getInstance();

        initOCR();

            // 버튼 클릭 시 이미지 가져오기
        StorageReference photoRef = storage.getReference("m1.jpg");
        File localFile = new File(getFilesDir(), "m1.jpg");
        binding.bonusUploadButton.setOnClickListener(v -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.OCRTextView.setText("EMPTY");

            photoRef.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
                Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    // 이미지 방향에 맞게 비트매 회전
                int orientation = getOrientationOfImage(localFile.getAbsolutePath());
                if (orientation != -1) {
                    bitmap = getRotatedBitmap(bitmap, orientation);
                }
                float radius = 2.0f; // Adjust this value as needed
                bitmap = removeNoise(KioskBonusAiActivity.this, bitmap, radius);
                bitmap=adjustContrastAndBrightness(bitmap, 5, 5);
                    // 이미지 미리보기
                binding.imageView.setImageBitmap(bitmap);
                    // OCR 처리
                processImage(bitmap, text -> {

                    binding.OCRTextView.setText(text);
                    binding.progressBar.setVisibility(View.GONE);
                    nlpBert();
                });
            }).addOnFailureListener(e -> {
                Toast.makeText(this, "이미지 다운로드 실패", Toast.LENGTH_SHORT).show();
            });
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

    public void nlpBert()  {
        TextView statusTextView = findViewById(R.id.Result_TextView);

        FirebaseLanguageIdentification languageIdentifier =
                FirebaseNaturalLanguage.getInstance().getLanguageIdentification();
        languageIdentifier.identifyLanguage(result)
                .addOnSuccessListener(
                            new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(@Nullable String languageCode) {
                                if (!"und".equals(languageCode)) {
                                        // 주어진 문장에서 감사, 주문완료, 카운터 단어가 있는지 확인
                                    if (result.contains("감사") || result.contains("완료") || result.contains("카운터")) {
                                            // 특정 단어를 찾았을 때
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                statusTextView.setText("Success");
                                            }
                                        });
                                    } else {
                                            // 특정 단어를 찾지 못했을 때
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                statusTextView.setText("Failure");
                                            }
                                        });
                                    }
                                } else {
                                    Log.i(TAG, "Can't identify language.");
                                }
                            }
                })
                .addOnFailureListener(
                            new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                    // Model couldn’t be loaded or other internal error.
                                    // ...
                            }
                });
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


