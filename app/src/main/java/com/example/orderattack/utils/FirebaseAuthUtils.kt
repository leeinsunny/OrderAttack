package com.example.orderattack.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuthUtils {
    companion object {
        private lateinit var auth : FirebaseAuth

        //파이어베이스의 uid를 가져오는 메소드를 정의하는 부분
        //  val uid = FirebaseAuthUtils.getUid() 이렇게 사용가능
        fun getUid() : String {
            auth = Firebase.auth
            return auth.currentUser?.uid.toString()
        }
    }
}