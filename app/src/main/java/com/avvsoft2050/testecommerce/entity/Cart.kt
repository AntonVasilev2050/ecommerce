package com.avvsoft2050.testecommerce.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.avvsoft2050.testecommerce.converters.Converter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cart")
@TypeConverters(Converter::class)
data class Cart(
    @SerializedName("basket")
    @Expose
    val basket: List<Basket>,

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