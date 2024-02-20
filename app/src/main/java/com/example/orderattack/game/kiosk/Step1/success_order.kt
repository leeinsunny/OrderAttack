package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivitySuccessOrderBinding

class success_order : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_order)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_success_order)

        binding.gohome.setOnClickListener {
            val intent = Intent(this, final_check_inburger::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}