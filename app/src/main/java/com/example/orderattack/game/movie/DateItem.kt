package com.example.orderattack.game.movie

data class DateItem(
    val imageResId: Int,
    val clickedImageResId: Int, // 클릭됐을 때의 이미지 리소스 ID
    var isClicked: Boolean = false, // 클릭 상태
    var isPlayed: Boolean = true    // 상영일정이 있는 날인지
)