package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivitySuccessOrderBinding
import com.example.orderattack.databinding.ActivityTogetherBinding

class together : AppCompatActivity() {

    private lateinit var binding: ActivityTogetherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_together)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_together)

        binding.nochoose.setOnClickListener {
            val intent = Intent(this, beforepay_ordercheck::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}