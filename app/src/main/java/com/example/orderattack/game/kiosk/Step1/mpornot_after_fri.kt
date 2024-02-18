package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityMpornotAfterFriBinding

class mpornot_after_fri : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotAfterFriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_after_fri)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_after_fri)

        binding.colamaterialchange.setOnClickListener {
            val intent = Intent(this, mpornot_coke::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}