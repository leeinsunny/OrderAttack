package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityMpornotFriAnswer1Binding

class mpornot_fri_answer1 : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotFriAnswer1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_fri_answer1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_fri_answer1)

        binding.savechange.setOnClickListener {
            val intent = Intent(this, mpornot_after_fri::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}