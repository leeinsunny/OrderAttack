package com.example.orderattack.auth

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.orderattack.MainActivity
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityJoinBinding
import com.example.orderattack.utils.FirebaseAuthUtils
import com.example.orderattack.utils.FirebaseRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

    val storage = Firebase.storage


    // 바로 밑에 있는 변수들은 realtime databse에 저장할 사용자의 정보들을 의미함
    private var name = ""
    private var phonenumber = ""
    private var birthdate = ""
    private var uid = ""
    private var nickname = ""
    private var id_email = ""
    private var pw = ""
    private var pwcheck = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailarea.text.toString()
            val password = binding.pwarea.text.toString()
            val passwordcheck = binding.pwcheckarea.text.toString()

            name = binding.namearea.text.toString()
            phonenumber = binding.phonenumarea.text.toString()
            birthdate = binding.birtharea.text.toString()
            nickname = binding.nicknamearea.text.toString()
            id_email = binding.emailarea.text.toString()
            pw = binding.pwarea.text.toString()
            pwcheck = binding.pwcheckarea.text.toString()

            //Check the empty valye
            if(email.isEmpty()){
                Toast.makeText(this,"이메일(아이디)를 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password.isEmpty()){
                Toast.makeText(this,"비밀번호를 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(passwordcheck.isEmpty()){

                Toast.makeText(this,"비밀번호와 비밀번호 확인의 입력 값이 다릅니다",Toast.LENGTH_LONG).show()

                isGoToJoin = false
            }
            if(name.isEmpty()){
                Toast.makeText(this,"이름을 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(phonenumber.isEmpty()){
                Toast.makeText(this,"휴대폰번호를 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(birthdate.isEmpty()){
                Toast.makeText(this,"생년월일을 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(!password.equals(passwordcheck)){
                Toast.makeText(this,"비밀번호를 똑같이 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(password.length<6){
                Toast.makeText(this,"비밀번호를 6자리 이상 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(birthdate.length!=8){
                Toast.makeText(this,"생년월일을 8자리로 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if(nickname.isEmpty()){
                Toast.makeText(this,"닉네임을 입력해주세요",Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(isGoToJoin){

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"회원가입 성공",Toast.LENGTH_LONG).show()

                            uid = FirebaseAuthUtils.getUid()
                            val userInfo = UserInfo( uid , name, phonenumber, birthdate,nickname,id_email, pw, pwcheck)
                            //userInfo라는 Reference(root 기준 첫번째 자식 노드)의 자식 노드는 uid를 key값으로 갖고,
                            // UserInfo라는 Data Class를 value로 갖는다.

                            FirebaseRef.userInfo.child(uid).setValue(userInfo)
                            imageUpload(uid)
                            val intent = Intent(this,MainActivity::class.java)

                            //회원가입 성공하고 main으로 넘어왔는데, 뒤로가기를 하면 회원가입페이지로 간다?
                            //이걸 막기위해서 flag를 사용했다! flag를 사용해서 main으로 넘어온뒤 뒤로가기하면 아예 어플이 종료되게끔
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)

                        } else {
                            Toast.makeText(this,"회원가입 실패",Toast.LENGTH_LONG).show()
                        }
                    }
            }



        }

        binding.pfphotoarea.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery,100)

        }
    }

    private fun imageUpload(uid:String){
        // Get the data from an ImageView as bytes
        val storage = Firebase.storage
        //Firebase의 Storage 서비스를 사용하기 위해 Firebase.storage 인스턴스를 생성함
        val storageRef = storage.reference.child(uid + ".jpeg")

        val imageView = binding.pfphotoarea
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()

        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = storageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK && requestCode==100){
            binding.pfphotoarea.setImageURI(data?.data)
        }
    }


}