package com.example.domain.models

data class WebImage (
    val url: String
)

data class PaintProps(
    val id: String,

    val title: String,

    val hasImage: String,

    val author: String,

    val longTitle: String,

    val image: WebImage
)
