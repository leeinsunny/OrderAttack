package com.example.orderattack.game.movie

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewerViewModel : ViewModel() {
    var totalViewers = 0
        private set
    var adultCount = 0
        private set
    var teenagerCount = 0
        private set
    var seniorCount = 0
        private set
    var handicapCount = 0
        private set

    fun updateCount(isIncrease: Boolean, countType: String) {
        when (countType) {
            "adult" -> if (isIncrease && totalViewers < 8) adultCount++ else if (!isIncrease && adultCount > 0) adultCount--
            "teenager" -> if (isIncrease && totalViewers < 8) teenagerCount++ else if (!isIncrease && teenagerCount > 0) teenagerCount--
            "senior" -> if (isIncrease && totalViewers < 8) seniorCount++ else if (!isIncrease && seniorCount > 0) seniorCount--
            "handicap" -> if (isIncrease && totalViewers < 8) handicapCount++ else if (!isIncrease && handicapCount > 0) handicapCount--
        }
        totalViewers = adultCount + teenagerCount + seniorCount + handicapCount
        Log.d("Debug", "After Update - TotalViewers: $totalViewers, Adult: $adultCount, Teenager: $teenagerCount, Senior: $seniorCount, Handicap: $handicapCount")
    }
}
