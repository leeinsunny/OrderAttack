package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityFinalCheckInburgerBinding
import com.example.orderattack.databinding.ActivityMpornotHamAnswer2Binding

class final_check_inburger : AppCompatActivity() {

    private lateinit var binding: ActivityFinalCheckInburgerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_check_inburger)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_final_check_inburger)

        binding.checkandpay.setOnClickListener {
            val intent = Intent(this, together::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}