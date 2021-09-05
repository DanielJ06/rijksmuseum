package com.example.presentation.viewModels

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import com.example.presentation.viewModels.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PaintViewModel(
    private val paintRepository: PaintRepository
) : BaseViewModel() {

    fun loadPaints(): Flow<PagingData<PaintProps>> {
        val data = paintRepository.getPaintsStream()
        viewModelScope.launch {
            data.collect {
                Log.i("TEST", it.toString())
            }
        }
        return data
    }
}
