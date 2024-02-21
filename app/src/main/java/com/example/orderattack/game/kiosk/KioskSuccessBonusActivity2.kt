package com.example.orderattack.game.kiosk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.example.orderattack.R
import com.example.orderattack.game.movie.Step1ClearActivity

class KioskSuccessBonusActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiosk_success_bonus2)

        // 지갑 장착 버튼
        findViewById<ImageButton>(R.id.btn_equip_wallet).setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val inflater = layoutInflater
            val popupView = inflater.inflate(R.layout.popup_kiosk_bonus_success, null)

            builder.setView(popupView)

            val alertDialog = builder.create()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog.show()
        }


        // 뒤로가기
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, KioskSuccessBonusActivity::class.java)
            startActivity(intent)
        }

    }
}