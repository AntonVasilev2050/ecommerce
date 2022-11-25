package com.avvsoft2050.testecommerce.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.avvsoft2050.testecommerce.api.ApiFactory
import com.avvsoft2050.testecommerce.database.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val cart = db.cartDao().getCart()
    val baskets = db.basketDao().getBaskets()

    init {
        loadCart()
        Thread.sleep(500)
    }

    private fun loadCart(){
        val disposable = ApiFactory.apiService.getCart()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.cartDao().insertCart(it)
                db.basketDao().insertBaskets(it.basket)
            },{
                Log.d("TEST_OF_LOADING_DATA", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}