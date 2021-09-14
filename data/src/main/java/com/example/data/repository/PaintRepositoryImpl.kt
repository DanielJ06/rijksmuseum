package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.dataSource.PaintDataSource
import com.example.domain.models.PaintProps
import com.example.domain.repository.PaintRepository
import kotlinx.coroutines.flow.Flow

class PaintRepositoryImpl(
    private val paintDataSource: PaintDataSource,
) : PaintRepository {

    override fun getPaintsStream(): Flow<PagingData<PaintProps>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PaintPagingSource(paintDataSource) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }

}