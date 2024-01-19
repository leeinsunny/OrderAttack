package com.example.orderattack.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.orderattack.MainActivity
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

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
            val name = binding.namearea.text.toString()
            val phonenumber = binding.phonenumarea.text.toString()
            val birthdate = binding.birtharea.text.toString()

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
                Toast.makeText(this,"비밀번호를 다시 한번 확인해주세요",Toast.LENGTH_LONG).show()
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

            if(isGoToJoin){
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this,"회원가입 성공",Toast.LENGTH_LONG).show()

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




    }


}