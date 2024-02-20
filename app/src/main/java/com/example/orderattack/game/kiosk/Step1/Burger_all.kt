package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityBurgerAllBinding


class Burger_all : AppCompatActivity() {
    private lateinit var binding : ActivityBurgerAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger_all)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_burger_all)

        binding.beefInall.setOnClickListener {
            val intent = Intent(this, Burger_beef::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.chickenInall.setOnClickListener {
            val intent = Intent(this, Burger_chicken::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.bulInall.setOnClickListener {
            val intent = Intent(this, Burger_bul::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.seafoodInall.setOnClickListener {
            val intent = Intent(this, burger_seafood::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }


    }
}