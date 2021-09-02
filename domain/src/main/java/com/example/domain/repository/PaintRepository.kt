package com.example.domain.repository

import com.example.domain.models.PaintProps
import kotlinx.coroutines.flow.Flow

interface PaintRepository {

    suspend fun getPaints(page: Int): Flow<List<PaintProps>>

}