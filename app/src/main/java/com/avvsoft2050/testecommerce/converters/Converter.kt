package com.avvsoft2050.testecommerce.converters

import androidx.room.TypeConverter
import com.avvsoft2050.testecommerce.entity.Basket
import com.avvsoft2050.testecommerce.entity.BestSeller
import com.avvsoft2050.testecommerce.entity.HomeStore
import com.google.gson.Gson

class Converter {

    private val gson = Gson()

    @TypeConverter
    fun listOfStringsToString(strings: List<String>): String {
        return gson.toJson(strings)
    }

    @TypeConverter
    fun stringToListOfStrings(string: String): List<String> {
        return gson.fromJson(string, ArrayList::class.java) as List<String>
    }

    @TypeConverter
    fun listOfHomeStoreToString(homeStore: List<HomeStore>): String {
        return gson.toJson(homeStore)
    }

    @TypeConverter
    fun stringToListOfHomeStore(string: String): List<HomeStore> {
        return gson.fromJson(string, List::class.java) as List<HomeStore>
    }

    @TypeConverter
    fun listOfBestSellerToString(bestSeller: List<BestSeller>): String {
        return gson.toJson(bestSeller)
    }

    @TypeConverter
    fun stringToListOfBestSeller(string: String): List<BestSeller> {
        return gson.fromJson(string, List::class.java) as List<BestSeller>
    }

    @TypeConverter
    fun listOfBasketToString(basket: List<Basket>): String {
        return gson.toJson(basket)
    }

    @TypeConverter
    fun stringToListOfBasket(string: String): List<Basket> {
        return gson.fromJson(string, List::class.java) as List<Basket>
    }


}