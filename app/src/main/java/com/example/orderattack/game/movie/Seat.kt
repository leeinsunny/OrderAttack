package com.example.orderattack.game.movie

data class Seat(
    var row: Char,
    val seatNumber: String,
    var isInitiallyAvailable: Boolean = true,
    var isAvailable: Boolean = true,
    var isSelected: Boolean = false
)
