package com.example.rijksmuseum.ui.fragments.home

import android.os.Bundle
import android.transition.ChangeBounds
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base_feature.core.BaseFragment
import com.example.base_feature.utils.delegateProps.viewInflateBinding
import com.example.presentation.viewModels.PaintViewModel
import com.example.presentation.viewModels.base.ViewState
import com.example.rijksmuseum.databinding.FragmentHomeBinding
import com.example.rijksmuseum.ui.adapters.PaintItemAdapter
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
        val gridLayout = GridLayoutManager(
            requireContext(), 2, GridLayoutManager.VERTICAL, false
        )
        binding.paintingsRv.layoutManager = gridLayout
    }

    override fun addObservers(owner: LifecycleOwner) {
        mAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                binding.loadingAnimation.visibility = View.VISIBLE
            } else if (loadState.refresh is LoadState.NotLoading) {
                binding.loadingAnimation.visibility = View.INVISIBLE
            }

            val errorState = when {
                loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                else -> null
            }
            errorState?.let {
                binding.errorText.visibility = View.VISIBLE
                binding.errorText.text = it.error.message
            }
        }

        mViewModel.paintsViewState.observe(owner, { res ->
            when (res) {
                is ViewState.Success -> {
                    res.data?.let {
                        lifecycleScope.launch {
                            mAdapter.submitData(it)
                        }
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