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
import com.example.orderattack.databinding.ActivitySetsideDrinkBinding

class setside_drink : AppCompatActivity() {
    private lateinit var binding: ActivitySetsideDrinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setside_drink)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setside_drink)

        binding.colamedium.setOnClickListener {
            val intent = Intent(this, mpornot::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.colazero.setOnClickListener {
            showRetryPopup()
        }

        binding.spritemedium.setOnClickListener {
            showRetryPopup()
        }

        binding.fantamedium.setOnClickListener {
            showRetryPopup()
        }

        binding.zadu.setOnClickListener {
            showRetryPopup()
        }

        binding.jeju.setOnClickListener {
            showRetryPopup()
        }

        binding.vanilashake.setOnClickListener {
            showRetryPopup()
        }

        binding.icedripcoffee.setOnClickListener {
            showRetryPopup()
        }

        binding.iceamericano.setOnClickListener {
            showRetryPopup()
        }

        binding.icecafelatte.setOnClickListener {
            showRetryPopup()
        }

        binding.icevanillalatte.setOnClickListener {
            showRetryPopup()
        }

        binding.hotdripcoffee.setOnClickListener {
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