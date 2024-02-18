package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityMpornotBinding

class mpornot : AppCompatActivity() {
    private lateinit var binding : ActivityMpornotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot)

        binding.hammaterialchange.setOnClickListener {
            val intent = Intent(this, mpornot_ham::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}