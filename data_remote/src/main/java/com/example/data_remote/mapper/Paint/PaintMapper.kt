package com.example.data_remote.mapper.Paint

import com.example.data_remote.response.PaintResponse
import com.example.domain.models.PaintProps
import com.example.domain.models.WebImage

fun PaintResponse.toDomain() =
    artObjects.map {
        PaintProps(
            author = it.author,
            id = it.id,
            hasImage = it.hasImage,
            title = it.title,
            longTitle = it.longTitle,
            image = WebImage(
                url = it.imageResponse.url
            )
        )
    }
