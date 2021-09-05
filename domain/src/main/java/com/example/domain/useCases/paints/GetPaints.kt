package com.example.domain.useCases.paints

import androidx.paging.PagingData
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import com.example.domain.utils.UseCase
import kotlinx.coroutines.CoroutineScope

class GetPaints(
    scope: CoroutineScope,
    private val paintRepository: PaintRepository
) : UseCase<PagingData<PaintProps>, GetPaints.Params>(scope) {

    override suspend fun run(params: Params?) = when (params) {
        null -> throw Exception("Params cannot be null")
        else -> try {
            paintRepository.getPaintsStream()
        } catch (e: Exception) {
            throw e
        }

    }

    data class Params(
        val page: Int
    )

}