package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivitySuccesswindowBinding
import com.example.orderattack.game.gameintro
import com.example.orderattack.game.kiosk.Kiosk_intro

class successwindow : AppCompatActivity() {

    private lateinit var binding: ActivitySuccesswindowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successwindow)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_successwindow)

        binding.getwallet.setOnClickListener {
            val intent = Intent(this,realwalletget::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.retry.setOnClickListener {
            val intent = Intent(this, Kiosk_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.gotomap.setOnClickListener {
            val intent = Intent(this, gameintro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}