package com.avvsoft2050.testecommerce.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "basket")
data class Basket(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

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

