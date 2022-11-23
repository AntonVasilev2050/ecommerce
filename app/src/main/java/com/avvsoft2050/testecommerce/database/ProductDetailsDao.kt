package com.avvsoft2050.testecommerce.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avvsoft2050.testecommerce.entity.ProductDetails

@Dao
interface ProductDetailsDao {

    @Query("SELECT * FROM product_details")
    fun getProductDetails(): LiveData<ProductDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductDetails(productDetails: ProductDetails)

}