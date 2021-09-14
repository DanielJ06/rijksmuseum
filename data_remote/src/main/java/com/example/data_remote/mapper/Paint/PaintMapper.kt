package com.example.data_remote.mapper.Paint

import com.example.data_remote.response.PaintResponse
import com.example.domain.models.PaintProps

fun PaintResponse.toDomain() =
    artObjects.map {
        PaintProps(
            author = it.author,
            id = it.id,
            objNumber = it.objNumber,
            hasImage = it.hasImage,
            title = it.title,
            longTitle = it.longTitle,
            image = it.imageResponse.url
        )
    }
