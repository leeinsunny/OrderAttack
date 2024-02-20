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
import com.example.orderattack.databinding.ActivityMpornotHamAnswer1Binding

class mpornot_ham_answer1 : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotHamAnswer1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_ham_answer1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_ham_answer1)

        binding.minusbtnofto.setOnClickListener {
            val intent = Intent(this, mpornot_ham_answer2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.plusbtnofto.setOnClickListener {
            showRetryPopup()
        }

        binding.plusbtn.setOnClickListener {
            showRetryPopup()
        }

        binding.minusbtn.setOnClickListener {
            showRetryPopup()
        }

    }

    private fun showRetryPopup() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.popup_comment_retry)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        dialog.setCancelable(true)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setOnCancelListener {
            // 뒤로 가기 버튼이 눌렸을 때 호출
            dialog.dismiss()
        }

        dialog.show()
    }
}