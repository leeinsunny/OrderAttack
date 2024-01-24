package com.example.orderattack.game

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityGameintroBinding


class gameintro: AppCompatActivity() {

    private lateinit var binding : ActivityGameintroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameintro)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gameintro)

        binding.stage1btnInintro.setOnClickListener {
            val intent = Intent(this, stage1_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.stage2btnInintro.setOnClickListener {
            val intent = Intent(this, stage2_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.stage3btnInintro.setOnClickListener {
            val intent = Intent(this, stage3_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}