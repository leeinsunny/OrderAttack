package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityBurgerBulBinding



class Burger_bul : AppCompatActivity() {

    private lateinit var binding: ActivityBurgerBulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_burger_bul)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_burger_bul)

        binding.beefInall.setOnClickListener {
            val intent = Intent(this, Burger_beef::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.alltab.setOnClickListener {
            val intent = Intent(this, Burger_all::class.java)
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