package com.example.orderattack.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.orderattack.MainActivity
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.loginBtninlogin.setOnClickListener{

            val email = binding.emailareainlogin.text.toString()
            val password = binding.pwareainlogin.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this,"로그인 성공",Toast.LENGTH_LONG).show()

                        //로그인 성공하면 MainActivity로 이동하게끔
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)

                    } else {

                        Toast.makeText(this,"로그인 실패",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}