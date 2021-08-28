package com.example.data_remote.response

import com.google.gson.annotations.SerializedName

data class WebImage (
    @SerializedName("url")
    val url: String
)

data class CollectionProps(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("hasImage")
    val hasImage: String,

    @SerializedName("principalOrFirstMaker")
    val author: String,

    @SerializedName("longTitle")
    val longTitle: String,

    @SerializedName("webImage")
    val image: WebImage
)

data class CollectionsResponse(
    @SerializedName("artObjects")
    val artObjects: List<CollectionProps>
)