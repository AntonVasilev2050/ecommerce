package com.avvsoft2050.testecommerce.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Basket(
    @SerializedName("id")
    @Expose
    val id: Int?,

    @SerializedName("images")
    @Expose
    val images: String?,

    @SerializedName("price")
    @Expose
    val price: Int?,

    @SerializedName("title")
    @Expose
    val title: String?
)

