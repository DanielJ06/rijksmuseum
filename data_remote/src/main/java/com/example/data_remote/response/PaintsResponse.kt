package com.example.data_remote.response

import com.google.gson.annotations.SerializedName

data class WebImageResponse (
    @SerializedName("url")
    val url: String?
)

data class PaintPropsResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("objectNumber")
    val objNumber: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("hasImage")
    val hasImage: Boolean,

    @SerializedName("principalOrFirstMaker")
    val author: String,

    @SerializedName("longTitle")
    val longTitle: String,

    @SerializedName("webImage")
    val imageResponse: WebImageResponse
)

data class PaintResponse(
    @SerializedName("artObjects")
    val artObjects: List<PaintPropsResponse>
)