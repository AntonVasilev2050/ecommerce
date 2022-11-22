package com.avvsoft2050.testecommerce.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "best_seller")
data class BestSeller(

    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("is_favorites")
    @Expose
    val isFavorites: Boolean?,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("price_without_discount")
    @Expose
    val priceWithoutDiscount: Int?,

    @SerializedName("discount_price")
    @Expose
    val discountPrice: Int?,

    @SerializedName("picture")
    @Expose
    val picture: String?
)