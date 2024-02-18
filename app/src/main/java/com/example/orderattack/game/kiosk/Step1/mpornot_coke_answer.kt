package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityMpornotCokeAnswerBinding


class mpornot_coke_answer : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotCokeAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_coke_answer)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_coke_answer)

        binding.savechange.setOnClickListener {
            val intent = Intent(this, mpornot_after_coke::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}