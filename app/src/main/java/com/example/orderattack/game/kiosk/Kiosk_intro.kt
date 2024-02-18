package com.example.orderattack.game.kiosk

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.orderattack.R
import com.example.orderattack.game.kiosk.Step1.KioskStep1Activity

class Kiosk_intro: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kioskintro)

        val step1Button = findViewById<ImageButton>(R.id.step1_btn)
        step1Button.setOnClickListener {
            showPopupStep1()
        }

        val step2Button = findViewById<ImageButton>(R.id.step2_btn)
        step2Button.setOnClickListener {
            showPopupStep2()
        }

        val step3Button = findViewById<ImageButton>(R.id.step3_btn)
        step3Button.setOnClickListener {
            showPopupStep3()
        }

        val stepBonusButton = findViewById<ImageButton>(R.id.stepbonus_btn)
        stepBonusButton.setOnClickListener {
            showPopupBonus()
        }


    }

    private fun showPopupStep1() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_kiosk_step1)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.findViewById<ImageButton>(R.id.startBtn).setOnClickListener {
            // 시작 버튼 클릭 시 KioskStep1Activity로 이동
            val intent = Intent(this, KioskStep1Activity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showPopupStep2() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_kiosk_step2)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.findViewById<ImageButton>(R.id.startBtn).setOnClickListener {
            // 시작 버튼 클릭 시 KioskStep2Activity로 이동
            val intent = Intent(this, KioskStep2Activity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showPopupStep3() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_kiosk_step3)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.findViewById<ImageButton>(R.id.startBtn).setOnClickListener {
            // 시작 버튼 클릭 시 KioskStep3Activity로 이동
            val intent = Intent(this, KioskStep3Activity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }

    private fun showPopupBonus() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_kiosk_bonus)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.findViewById<ImageButton>(R.id.startBtn).setOnClickListener {
            // 시작 버튼 클릭 시 KioskStep3Activity로 이동
            val intent = Intent(this, KioskBonusActivity::class.java)
            startActivity(intent)
        }

        dialog.show()
    }


}