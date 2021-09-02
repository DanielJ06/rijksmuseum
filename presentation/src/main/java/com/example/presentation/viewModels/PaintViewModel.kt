package com.example.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import com.example.domain.models.PaintProps
import com.example.domain.useCases.paints.GetPaints
import com.example.presentation.viewModels.base.BaseViewModel
import com.example.presentation.viewModels.base.ViewState
import com.example.presentation.viewModels.base.extensions.useCase

class PaintViewModel : BaseViewModel() {

    private val getPaints: GetPaints by useCase()

    val paintsViewState: MutableLiveData<ViewState<List<PaintProps>>> = MutableLiveData()
    var currentPage = 1

    fun loadPaints() {
        getPaints(
            params = GetPaints.Params(currentPage),
            onSuccess = {
                paintsViewState.value = ViewState.Success(it)
                currentPage += 1
            },
            onError = {
                paintsViewState.value = ViewState.Error("Something went wrong")
            }
        )
    }
}