package com.example.rijksmuseum.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.utils.delegateProps.viewInflateBinding
import com.example.presentation.viewModels.PaintViewModel
import com.example.presentation.viewModels.base.ViewState
import com.example.rijksmuseum.databinding.FragmentHomeBinding
import com.example.rijksmuseum.ui.adapters.PaintItemAdapter
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
        binding.paintingsRv.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )

        binding.paintingsRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    mViewModel.loadPaints()
                }
            }
        })
    }

    override fun addObservers(owner: LifecycleOwner) {
        mViewModel.paintsViewState.observe(owner, { res ->
            when (res) {
                is ViewState.Success -> {
                    res.data?.let {
                        mAdapter.setData(it)
                    }
                }
                is ViewState.Error -> {
                    Log.i("DEBUG", res.message.toString())
                }
                else -> {
                    Log.i("DEBUG", res.message.toString())
                }
            }
        })
    }

}