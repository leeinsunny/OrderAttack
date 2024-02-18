package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityKioskStep1Binding


class  KioskStep1Activity : AppCompatActivity() {

    private lateinit var binding : ActivityKioskStep1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiosk_step1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kiosk_step1)

        binding.kioskStartorderBtn.setOnClickListener {
            val intent = Intent(this, ChooseplaceActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }
}