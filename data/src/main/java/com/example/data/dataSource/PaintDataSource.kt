package com.example.data.dataSource

import com.example.domain.models.PaintProps

interface PaintDataSource {

    suspend fun getPaints(page: Int): List<PaintProps>

}