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
        var position = params.key ?: PAINT_PAGE_INDEX

        return try {
            val paints = paintDataSource.getPaints(position)
            val nextKey = if (paints.isEmpty()) {
                null
            } else {
                position++
            }
            Log.i("Pixel", paints.toString())
            Log.i("Pixel", position.toString())
            LoadResult.Page(
                data = paints,
                prevKey = if (position == PAINT_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            Log.i("Pixel", e.toString())
            return LoadResult.Error(e)
        }
    }

}