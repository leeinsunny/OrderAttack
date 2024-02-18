package com.example.orderattack.game.kiosk.Step1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityChooseplaceBinding

class ChooseplaceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChooseplaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooseplace)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_chooseplace)

        binding.kioskChooseplaceTable.setOnClickListener {
            val intent = Intent(this, home_beforeorder::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }
}