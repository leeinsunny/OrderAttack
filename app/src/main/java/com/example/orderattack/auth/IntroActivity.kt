package com.example.orderattack.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityIntroBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_intro)

        binding.loginBtnIntro.setOnClickListener{

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)


        }

        binding.joinBtn.setOnClickListener{

            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)

        }
    }
}