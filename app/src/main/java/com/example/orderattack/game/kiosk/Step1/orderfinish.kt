package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityOrderfinishBinding

class orderfinish : AppCompatActivity() {

    private lateinit var binding: ActivityOrderfinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderfinish)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_orderfinish)

        binding.getproduct.setOnClickListener {
            val intent = Intent(this, successwindow::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }
}