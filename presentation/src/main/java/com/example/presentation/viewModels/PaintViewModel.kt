package com.example.presentation.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import com.example.domain.useCases.paints.GetPaints
import com.example.presentation.viewModels.base.BaseViewModel
import com.example.presentation.viewModels.base.ViewState
import com.example.presentation.viewModels.base.extensions.useCase
import kotlinx.coroutines.flow.Flow

class PaintViewModel() : BaseViewModel() {

    private val getPaints: GetPaints by useCase()

    val paintsViewState: MutableLiveData<ViewState<PagingData<PaintProps>>> = MutableLiveData()

    fun loadPaints() {
        getPaints(
            onSuccess = {
                paintsViewState.value = ViewState.Success(it)
            },
            onError = {
                Log.i("DEBUG", it.toString())
                paintsViewState.value = ViewState.Error("Something went wrong")
            }
        )
    }
}
