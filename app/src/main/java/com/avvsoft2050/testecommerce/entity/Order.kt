package com.avvsoft2050.testecommerce.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("basket")
    @Expose
    val basket: List<Basket>?,

    @SerializedName("delivery")
    @Expose
    val delivery: String?,

    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("total")
    @Expose
    val total: Int?
)