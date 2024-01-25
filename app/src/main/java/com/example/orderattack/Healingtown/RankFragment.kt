package com.example.orderattack.Healingtown

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.orderattack.R
import com.example.orderattack.databinding.FragmentRankBinding

class RankFragment : Fragment() {
    // 참고 ) 액티비티 바인딩이랑 프래그먼트 바인딩은 방식이 살짝 다르다
    private lateinit var binding : FragmentRankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_rank, container, false)

        binding.ourtown.setOnClickListener {
            it.findNavController().navigate(R.id.action_rankFragment_to_ourtownFragment)
        }

        binding.wallet.setOnClickListener {
            it.findNavController().navigate(R.id.action_rankFragment_to_walletFragment)
        }

        binding.chat.setOnClickListener {
            it.findNavController().navigate(R.id.action_rankFragment_to_chattingFragment)
        }

        binding.mypage.setOnClickListener {
            it.findNavController().navigate(R.id.action_rankFragment_to_mypageFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}