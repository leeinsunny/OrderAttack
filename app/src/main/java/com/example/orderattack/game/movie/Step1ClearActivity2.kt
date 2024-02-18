package com.example.orderattack.game.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.orderattack.R

class Step1ClearActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step1_clear2)

        // 지갑 장착 버튼
        findViewById<Button>(R.id.btn_equip_wallet).setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val inflater = layoutInflater
            val popupView = inflater.inflate(R.layout.popup_movie1_success, null)

            builder.setView(popupView)

            val alertDialog = builder.create()
            alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            alertDialog.show()
        }


        // 뒤로가기
        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, Step1ClearActivity::class.java)
            startActivity(intent)
        }
    }
}