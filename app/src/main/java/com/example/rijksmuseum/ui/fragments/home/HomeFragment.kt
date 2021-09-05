package com.example.rijksmuseum.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.utils.delegateProps.viewInflateBinding
import com.example.presentation.viewModels.PaintViewModel
import com.example.presentation.viewModels.base.ViewState
import com.example.rijksmuseum.databinding.FragmentHomeBinding
import com.example.rijksmuseum.ui.adapters.PaintItemAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)

    private val mViewModel: PaintViewModel by viewModel()
    private val mAdapter by lazy { PaintItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun setupView() {
        mViewModel.loadPaints()

        binding.paintingsRv.adapter = mAdapter
        val linearLayout = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        binding.paintingsRv.layoutManager = linearLayout

        initViewModel()
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            mViewModel.loadPaints().collectLatest {
                Log.i("DEBUG", it.toString())
                mAdapter.submitData(it)
            }
        }
    }

}