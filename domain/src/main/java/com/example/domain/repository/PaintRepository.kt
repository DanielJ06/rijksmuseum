package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.models.PaintProps
import kotlinx.coroutines.flow.Flow

interface PaintRepository {

    fun getPaintsStream(): Flow<PagingData<PaintProps>>

}