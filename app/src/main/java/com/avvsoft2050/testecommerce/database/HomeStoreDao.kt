package com.avvsoft2050.testecommerce.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avvsoft2050.testecommerce.entity.HomeStore

@Dao
interface HomeStoreDao {

    @Query("SELECT * FROM home_store")
    fun getHomeStores(): LiveData<List<HomeStore>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHomeStores(homeStores: List<HomeStore>)
}