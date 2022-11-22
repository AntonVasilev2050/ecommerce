package com.avvsoft2050.testecommerce.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "home_store")
data class HomeStore(

    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("is_new")
    @Expose
    val isNew: Boolean?,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("subtitle")
    @Expose
    val subtitle: String?,

    @SerializedName("picture")
    @Expose
    val picture: String?,

    @SerializedName("is_buy")
    @Expose
    val isBuy: Boolean?
)