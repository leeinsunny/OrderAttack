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
import com.example.orderattack.databinding.ActivityMpornotAfterFriBinding

class mpornot_after_fri : AppCompatActivity() {

    private lateinit var binding: ActivityMpornotAfterFriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mpornot_after_fri)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mpornot_after_fri)

        binding.colamaterialchange.setOnClickListener {
            val intent = Intent(this, mpornot_coke::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.hammaterialchange.setOnClickListener {
            showRetryPopup()
        }

        binding.frimaterialchange.setOnClickListener {
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