package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityMpornotAfterCokeBinding
import com.example.orderattack.databinding.ActivityMpornotAfterFriBinding

class mpornot_after_coke : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotAfterCokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_after_coke)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_after_coke)

        binding.basket.setOnClickListener {
            val intent = Intent(this, success_order::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}