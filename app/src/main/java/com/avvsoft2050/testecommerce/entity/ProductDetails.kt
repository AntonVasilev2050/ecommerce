package com.avvsoft2050.testecommerce.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductDetails (
    @SerializedName("CPU")
    @Expose
    val cpu: String?,

    @SerializedName("camera")
    @Expose
    val camera: String?,

    @SerializedName("capacity")
    @Expose
    val capacity: List<String>?,

    @SerializedName("color")
    @Expose
    val color: List<String>?,

    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("images")
    @Expose
    val images: List<String>?,

    @SerializedName("isFavorites")
    @Expose
    val isFavorites: Boolean?,

    @SerializedName("price")
    @Expose
    val price: Int?,

    @SerializedName("rating")
    @Expose
    val rating: Double?,

    @SerializedName("sd")
    @Expose
    val sd: String?,

    @SerializedName("ssd")
    @Expose
    val ssd: String?,

    @SerializedName("title")
    @Expose
    val title: String?
)