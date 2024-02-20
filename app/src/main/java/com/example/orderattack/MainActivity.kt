package com.example.orderattack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.orderattack.Healingtown.HealingMainActivity
import com.example.orderattack.auth.IntroActivity
import com.example.orderattack.databinding.ActivityMainBinding
import com.example.orderattack.game.gameintro
import com.example.orderattack.utils.FirebaseRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityMainBinding

    private val userInfoList = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.logoutinmain.setOnClickListener{

            auth.signOut()

            val intent = Intent(this, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)

        }

        binding.gamestartInmain.setOnClickListener{
            val intent = Intent(this, gameintro::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        binding.gohealingInmain.setOnClickListener{
            val intent = Intent(this, HealingMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }

//    private fun getUserInfoList() {
//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for(dataModel in dataSnapshot.children) {
//                    val userInfo = dataModel.getValue(UserInfo::class.java)
//                    userInfoList.add(userInfo!!)
//                }
//                //cardStackAdapter.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(databseError: DatabaseError) {
//                Log.w("MainActivity", "onCancelled", databseError.toException())
//            }
//        }
//        FirebaseRef.userInfo.addValueEventListener(postListener)
//    }
    
}
