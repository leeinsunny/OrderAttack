package com.example.orderattack.game.kiosk.Step1

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.orderattack.R
import com.example.orderattack.databinding.ActivityRealwalletgetBinding


class realwalletget : AppCompatActivity() {

    private lateinit var binding: ActivityRealwalletgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realwalletget)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_realwalletget)

        binding.back.setOnClickListener {
            val intent = Intent(this, successwindow::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.setwallet.setOnClickListener {
           showSuccessPopup()
        }
    }

    private fun showSuccessPopup() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_notice_success_lv1)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }


        dialog.show()
    }
}