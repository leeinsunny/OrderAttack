package com.example.orderattack.Healingtown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.orderattack.R
import com.example.orderattack.databinding.FragmentOurtownBinding


class OurtownFragment : Fragment() {

    private lateinit var binding : FragmentOurtownBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ourtown, container, false)

        binding.rank.setOnClickListener {
            it.findNavController().navigate(R.id.action_ourtownFragment_to_rankFragment)
        }

        binding.wallet.setOnClickListener {
            it.findNavController().navigate(R.id.action_ourtownFragment_to_walletFragment)
        }

        binding.chat.setOnClickListener {
            it.findNavController().navigate(R.id.action_ourtownFragment_to_chattingFragment)
        }

        binding.mypage.setOnClickListener {
            it.findNavController().navigate(R.id.action_ourtownFragment_to_mypageFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}