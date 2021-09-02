package com.example.rijksmuseum.ui.fragments.paint

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.utils.delegateProps.viewInflateBinding
import com.example.rijksmuseum.databinding.FragmentPaintDetailsBinding

class PaintDetailsFragment : BaseFragment() {

    private val binding by viewInflateBinding(FragmentPaintDetailsBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

}