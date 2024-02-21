package com.example.orderattack.Healingtown

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.orderattack.R
import com.example.orderattack.auth.IntroActivity
import com.example.orderattack.auth.UserInfo
import com.example.orderattack.databinding.FragmentMypageBinding
import com.example.orderattack.utils.FirebaseAuthUtils
import com.example.orderattack.utils.FirebaseRef
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class MypageFragment : Fragment() {
    private lateinit var binding : FragmentMypageBinding

    private val uid = FirebaseAuthUtils.getUid()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMypageBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        getMyData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mypage, container, false)

        binding.rank.setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_rankFragment)
        }

        binding.ourtown.setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_ourtownFragment)
        }

        binding.chat.setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_chattingFragment)
        }

        binding.wallet.setOnClickListener {
            it.findNavController().navigate(R.id.action_mypageFragment_to_walletFragment)
        }

        binding.modifymyinfoInmypage.setOnClickListener{
            val intent = Intent(requireActivity(), MypageActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)

        }

        binding.logoutInmypage.setOnClickListener{
            val intent = Intent(requireActivity(), IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getMyData(){
        val myprofile = binding.presentpfInmypage
        val myname = binding.presentusernameInmypage

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val data = dataSnapshot.getValue(UserInfo::class.java)

                if (data != null) {
                    // EditText에 데이터를 입력하는 것으로 변경
                    binding.presentusernameInmypage.setText(data?.name)

                    // data.uid가 null이 아닌 경우에만 이미지 로딩을 시도
                    data?.uid?.let { uid ->
                        val storageRef = Firebase.storage.reference.child("$uid.jpeg")
                        storageRef.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("Glide", task.toString())
                                Glide.with(this@MypageFragment)
                                    .load(task.result)
                                    .into(binding.presentpfInmypage)
                            } else {
                                // 이미지 로딩에 실패한 경우 처리
                                Log.e("Glide", "Image loading failed", task.exception)
                            }
                        })
                    }
                } else {
                    // data가 null인 경우 처리
                    Log.e("MypageActivity", "Data is null")
                }
            }
            override fun onCancelled(databseError: DatabaseError) {
                Log.w("MainActivity", "onCancelled", databseError.toException())
            }
        }
        FirebaseRef.userInfo.child(uid).addValueEventListener(postListener)
    }
}