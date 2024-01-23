package com.example.orderattack.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

//Realtime Database에 값을 저장하기 위한 정적 멤버 함수
class FirebaseRef {
    companion object {
        val database = Firebase.database
        val userInfo = database.getReference("userInfo")
    }
}