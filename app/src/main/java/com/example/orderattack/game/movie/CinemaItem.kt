package com.example.orderattack.game.movie

data class CinemaItem(
    val cinemaName: String,
    val region: String,
    var isClicked: Boolean = false
)