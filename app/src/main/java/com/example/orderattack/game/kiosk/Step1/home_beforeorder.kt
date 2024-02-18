package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityChooseplaceBinding
import com.example.orderattack.databinding.ActivityHomeBeforeorderBinding

class home_beforeorder : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBeforeorderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_beforeorder)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_beforeorder)

        binding.kioskBurgertab.setOnClickListener {
            val intent = Intent(this, Burger_all::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }
}