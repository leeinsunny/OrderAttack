package com.example.orderattack.game.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.orderattack.R
import com.example.orderattack.game.gameintro

class Step1ClearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step1_clear)

        // 지갑 획득 버튼
        findViewById<Button>(R.id.btn_get_wallet).setOnClickListener {
            val intent = Intent(this, Step1ClearActivity2::class.java)
            startActivity(intent)
        }

        // 다시 연습 버튼
        findViewById<Button>(R.id.btn_back_to_practice).setOnClickListener {
            val intent = Intent(this, MovieStep1Activity::class.java)
            startActivity(intent)
        }

        // 지도로 돌아가기 버튼
        findViewById<Button>(R.id.btn_back_to_map).setOnClickListener {
            val intent = Intent(this, gameintro::class.java)
            startActivity(intent)
        }
    }
}