package com.avvsoft2050.testecommerce.entity

import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.avvsoft2050.testecommerce.converters.Converter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@TypeConverters(Converter::class)
data class Goods (

    @PrimaryKey
    val goodsId: Int = 1,

    @SerializedName("home_store")
    @Expose
    val homeStore: List<HomeStore>?,

    @SerializedName("best_seller")
    @Expose
    val bestSeller: List<BestSeller>?
)