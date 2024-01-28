package com.example.orderattack.Healingtown

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.orderattack.auth.UserInfo
import com.example.orderattack.databinding.ActivityMypageBinding
import com.example.orderattack.utils.FirebaseAuthUtils
import com.example.orderattack.utils.FirebaseRef
import com.example.orderattack.utils.FirebaseRef.Companion.userInfo
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream


class MypageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMypageBinding
    private val uid = FirebaseAuthUtils.getUid()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMyData()

        binding.modifyapplyBtnInmypage.setOnClickListener {
            editmyinfo()
        }

        binding.pfreuploadInmypage.setOnClickListener {
            imageUpload(uid)
        }

    }

    private fun getMyData(){
        val myprofile = binding.pfphotoareaInmypage
        val myidemail = binding.emailareaInmypage
        val mypw = binding.pwareaInmypage
        val mypwcheck = binding.pwcheckareaInmypage
        val myname = binding.nameareaInmypage
        val mynickname = binding.nicknameareaInmypage
        val myphonenum = binding.phonenumareaInmypage
        val mybirth = binding.birthareaInmypage

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val data = dataSnapshot.getValue(UserInfo::class.java)

                    if (data != null) {
                        // EditText에 데이터를 입력하는 것으로 변경
                        binding.emailareaInmypage.setText(data?.id_email)
                        binding.nameareaInmypage.setText(data?.name)
                        binding.nicknameareaInmypage.setText(data?.nickname)
                        binding.pwareaInmypage.setText(data?.pw)
                        binding.pwcheckareaInmypage.setText(data?.pwcheck)
                        binding.phonenumareaInmypage.setText(data?.phonenumber)
                        binding.birthareaInmypage.setText(data?.birthdate)


                        // data.uid가 null이 아닌 경우에만 이미지 로딩을 시도
                        data?.uid?.let { uid ->
                            val storageRef = Firebase.storage.reference.child("$uid.jpeg")
                            storageRef.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Log.d("Glide", task.toString())
                                    Glide.with(this@MypageActivity)
                                        .load(task.result)
                                        .into(binding.pfphotoareaInmypage)
                                } else {
                                    // 이미지 로딩에 실패한 경우 처리
                                    Log.e("Glide", "Image loading failed", task.exception)
                                }
                            })
                        }
                    } else {
                        // data가 null인 경우 처리
                        Log.e("MypageActivity", "Data is null")
                    }
            }

            override fun onCancelled(databseError: DatabaseError) {
                Log.w("MainActivity", "onCancelled", databseError.toException())
            }
        }

        FirebaseRef.userInfo.child(uid).addValueEventListener(postListener)

    }

    private fun editmyinfo(){
        val userInfo = UserInfo(
            uid ,
            binding.nameareaInmypage.text.toString(),
            binding.phonenumareaInmypage.text.toString(),
            binding.birthareaInmypage.text.toString(),
            binding.nicknameareaInmypage.text.toString(),
            binding.emailareaInmypage.text.toString(),
            binding.pwareaInmypage.text.toString(),
            binding.pwcheckareaInmypage.text.toString()
        )
        FirebaseRef.userInfo.child(uid).setValue(userInfo)

        Toast.makeText(this,"수정완료",Toast.LENGTH_LONG).show()

        // 결과 설정
        val intent = Intent().apply {
            putExtra("result", "Success")
        }
        setResult(RESULT_OK, intent)

    }


    private fun imageUpload(uid:String){
        // 갤러리에서 이미지를 선택하기 위한 Intent 생성
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100) {
            // 선택한 이미지를 ImageView에 설정
            binding.pfphotoareaInmypage.setImageURI(data?.data)

            // 선택한 이미지를 Firebase Storage에 업로드
            data?.data?.let { imageUri ->
                val storageRef = Firebase.storage.reference.child("$uid.jpeg")
                val imageView = binding.pfphotoareaInmypage
                imageView.isDrawingCacheEnabled = true
                imageView.buildDrawingCache()

                val bitmap = (imageView.drawable as BitmapDrawable).bitmap
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                val imageData = baos.toByteArray()

                val uploadTask = storageRef.putBytes(imageData)
                uploadTask.addOnFailureListener {
                    // Handle unsuccessful uploads
                    Log.e("Firebase", "Image upload failed", it)
                }.addOnSuccessListener { taskSnapshot ->
                    // Handle successful uploads
                    Log.d("Firebase", "Image upload successful")
                    Toast.makeText(this, "프로필 사진이 업로드되었습니다.", Toast.LENGTH_SHORT).show()

                    // 여기서 updateProfileImage 함수를 호출하지 않음
                }
            }
        }
    }


}