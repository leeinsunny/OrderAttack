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
import com.example.orderattack.databinding.ActivityFinalCheckInburgerBinding
import com.example.orderattack.databinding.ActivityMpornotHamAnswer2Binding

class final_check_inburger : AppCompatActivity() {

    private lateinit var binding: ActivityFinalCheckInburgerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_check_inburger)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_final_check_inburger)

        binding.checkandpay.setOnClickListener {
            val intent = Intent(this, together::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.beefInall.setOnClickListener {
            showRetryPopup()
        }

        binding.alltab.setOnClickListener {
            showRetryPopup()
        }

        binding.chickenInall.setOnClickListener {
            showRetryPopup()
        }

        binding.bulInall.setOnClickListener {
            showRetryPopup()
        }

        binding.seafoodInall.setOnClickListener {
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