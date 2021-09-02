package com.example.data.repository

import com.example.data.dataSource.PaintDataSource
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import kotlinx.coroutines.flow.Flow

class PaintRepositoryImpl(
    private val paintDataSource: PaintDataSource
): PaintRepository {

    override suspend fun getPaints(page: Int): Flow<List<PaintProps>> {
        return paintDataSource.getPaints(page)
    }

}