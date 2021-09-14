package com.example.domain.useCases.paints

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import com.example.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPaints(
    scope: CoroutineScope,
    private val paintRepository: PaintRepository
) : UseCase<PagingData<PaintProps>, GetPaints.Params>(scope) {

    override suspend fun run(params: Params?): Flow<PagingData<PaintProps>> {
        try {
            return paintRepository.getPaintsStream().cachedIn(scope)
        } catch (e: Exception) {
            throw e
        }
    }

    data class Params(
        val page: Int
    )

}