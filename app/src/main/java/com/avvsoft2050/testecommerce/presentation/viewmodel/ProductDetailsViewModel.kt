package com.avvsoft2050.testecommerce.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.avvsoft2050.testecommerce.api.ApiFactory
import com.avvsoft2050.testecommerce.database.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val productDetails = db.productDetailsDao().getProductDetails()

    init {
        loadProductDetails()
        Thread.sleep(300)
    }

    private fun loadProductDetails() {
        val disposable = ApiFactory.apiService.getProductDetails()
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.productDetailsDao().insertProductDetails(it)
            }, {
                Log.d("TEST_OF_LOADING_DATA", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}