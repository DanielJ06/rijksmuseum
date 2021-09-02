package com.example.data_remote.dataSource

import com.example.data.dataSource.PaintDataSource
import com.example.data_remote.mapper.Paint.toDomain
import com.example.data_remote.services.PaintsService
import kotlinx.coroutines.flow.flow

class PaintDataSourceImpl(
    private val paintsService: PaintsService
) : PaintDataSource {

    override suspend fun getPaints(page: Int) = flow {
        emit(
            paintsService.loadPaints(page).toDomain()
        )
    }

}