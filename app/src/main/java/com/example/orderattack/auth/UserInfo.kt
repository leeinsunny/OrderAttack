package com.example.orderattack.auth

data class UserInfo(
    val uid : String? = null,
    val name : String? = null,
    val phonenumber : String? = null,
    val birthdate : String? = null,
    val nickname : String? = null,
    val id_email : String? = null,
    val pw : String? = null,
    val pwcheck : String? = null
)
