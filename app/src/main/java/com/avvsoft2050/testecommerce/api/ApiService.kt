package com.avvsoft2050.testecommerce.api

import com.avvsoft2050.testecommerce.entity.Goods
import com.avvsoft2050.testecommerce.entity.Order
import com.avvsoft2050.testecommerce.entity.ProductDetails
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getGoods(): Single<Goods>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getProductDetails(): Single<ProductDetails>

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getOrder(): Single<Order>
}