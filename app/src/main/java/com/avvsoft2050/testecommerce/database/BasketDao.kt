package com.avvsoft2050.testecommerce.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avvsoft2050.testecommerce.entity.Basket

@Dao
interface BasketDao {

    @Query("SELECT * FROM basket")
    fun getBaskets(): LiveData<List<Basket>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBaskets(baskets: List<Basket>)
}