package com.example.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.dataSource.PaintDataSource
import com.example.domain.models.PaintProps

private const val PAINT_PAGE_INDEX = 1


class PaintPagingSource(
    private val paintDataSource: PaintDataSource
) : PagingSource<Int, PaintProps>() {

    override fun getRefreshKey(state: PagingState<Int, PaintProps>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PaintProps> {
        val position = params.key ?: PAINT_PAGE_INDEX

        return try {
            val paints = paintDataSource.getPaints(position)
            paints.let {
                val nextKey = if (it.isEmpty()) {
                    null
                } else {
                    position + 1
                }
                LoadResult.Page(
                    data = it,
                    prevKey = if (position == PAINT_PAGE_INDEX) null else position - 1,
                    nextKey = nextKey
                )

            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}