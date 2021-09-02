package com.example.data.dataSource

import com.example.domain.models.PaintProps
import kotlinx.coroutines.flow.Flow

interface PaintDataSource {

    suspend fun getPaints(page: Int): Flow<List<PaintProps>>

}