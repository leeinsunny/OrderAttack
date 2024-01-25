package com.example.orderattack.Healingtown

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.orderattack.R
import com.example.orderattack.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private lateinit var binding : FragmentMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        // Inflate the layout for this fragment
        return binding.root
    }

}