package com.example.orderattack.game.kiosk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.orderattack.R
import com.example.orderattack.game.gameintro
import com.example.orderattack.game.movie.MovieStep1Activity
import com.example.orderattack.game.movie.Step1ClearActivity2

class KioskSuccessBonusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiosk_success_bonus)

        // 지갑 획득 버튼
        findViewById<ImageButton>(R.id.btn_get_wallet).setOnClickListener {
            val intent = Intent(this, KioskSuccessBonusActivity2::class.java)
            startActivity(intent)
        }


        // 지도로 돌아가기 버튼
        findViewById<ImageButton>(R.id.btn_back_to_map).setOnClickListener {
            val intent = Intent(this, gameintro::class.java)
            startActivity(intent)
        }
    }
}