package com.example.rijksmuseum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.utils.delegateProps.viewInflateBinding
import com.example.rijksmuseum.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

}