package com.example.orderattack.game

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityGameintroBinding
import com.example.orderattack.game.bus.Bus_intro
import com.example.orderattack.game.kiosk.Kiosk_intro
import com.example.orderattack.game.movie.Movie_intro


class gameintro: AppCompatActivity() {

    private lateinit var binding : ActivityGameintroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameintro)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gameintro)

        binding.stage1btnInintro.setOnClickListener {
            val intent = Intent(this, Kiosk_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.stage2btnInintro.setOnClickListener {
            val intent = Intent(this, Movie_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.stage3btnInintro.setOnClickListener {
            val intent = Intent(this, Bus_intro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}