package com.avvsoft2050.testecommerce.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avvsoft2050.testecommerce.entity.Cart

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getCart(): LiveData<Cart>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCart(cart: Cart)
}