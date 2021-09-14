package com.example.data_remote.dataSource

import android.util.Log
import com.example.data.dataSource.PaintDataSource
import com.example.data_remote.mapper.Paint.toDomain
import com.example.data_remote.services.PaintsService
import com.example.domain.models.PaintProps

class PaintDataSourceImpl(
    private val paintsService: PaintsService
) : PaintDataSource {

    override suspend fun getPaints(page: Int): List<PaintProps> {
        val data = paintsService.loadPaints(page)
        return data.toDomain()
    }
}
