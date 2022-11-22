package com.avvsoft2050.testecommerce.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.avvsoft2050.testecommerce.api.ApiFactory
import com.avvsoft2050.testecommerce.database.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val homeStores = db.homeStoreDao().getHomeStores()
    val bestSellers = db.bestSellerDao().getBestSellers()

    fun loadGoods() {
        val disposable = ApiFactory.apiService.getGoods()
            .subscribeOn(Schedulers.io())
            .subscribe({ goods ->
                goods.homeStore?.let { homeStoreList ->
                    db.homeStoreDao().insertHomeStores(homeStoreList)
                }
                goods.bestSeller?.let { bestSellerList ->
                    db.bestSellerDao().insertBestSellers(bestSellerList)
                }
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