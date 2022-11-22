package com.avvsoft2050.testecommerce.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avvsoft2050.testecommerce.entity.BestSeller

@Dao
interface BestSellerDao {

    @Query("SELECT * FROM best_seller")
    fun getBestSellers(): LiveData<List<BestSeller>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBestSellers(bestSellers: List<BestSeller>)
}