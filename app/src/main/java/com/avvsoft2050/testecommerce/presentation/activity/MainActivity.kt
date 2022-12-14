package com.avvsoft2050.testecommerce.presentation.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.avvsoft2050.testecommerce.adapters.BestSellerAdapter
import com.avvsoft2050.testecommerce.adapters.HotSalesAdapterR
import com.avvsoft2050.testecommerce.databinding.ActivityMainBinding
import com.avvsoft2050.testecommerce.databinding.DialogFiltersBinding
import com.avvsoft2050.testecommerce.entity.HomeStore
import com.avvsoft2050.testecommerce.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapterHotSales: HotSalesAdapterR
    private lateinit var viewPagerHotSales: ViewPager2
    private lateinit var adapterBestSellers: BestSellerAdapter
    private lateinit var recyclerViewBestSeller: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewBestSeller = binding.recyclerViewBestSeller
        viewPagerHotSales = binding.viewPagerHotSales
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        adapterBestSellers = BestSellerAdapter(
            onClickAction = {
                val i = Intent(this, ProductDetailsActivity::class.java)
                startActivity(i)
            }
        )

        binding.imageViewFilter.setOnClickListener {
            showFilterDialog()
        }

        mainViewModel.homeStores.observe(this) {
            adapterHotSales = HotSalesAdapterR(it)
            viewPagerHotSales.adapter = adapterHotSales
            adapterHotSales.onHomeStoreClickListener = object : HotSalesAdapterR.OnHomeStoreClickListener{
                override fun onBuyNowClick(homeStore: HomeStore) {
                    val intent = Intent(applicationContext, ProductDetailsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        mainViewModel.bestSellers.observe(this) {
            it?.let {
                adapterBestSellers.submitList(it)
                recyclerViewBestSeller.adapter = adapterBestSellers
            }
        }
    }

    private fun showFilterDialog() {
        val filterDialog = Dialog(this)
        val bindingDialogFilter = DialogFiltersBinding.inflate(layoutInflater)
        filterDialog.setContentView(bindingDialogFilter.root)

        bindingDialogFilter.imageViewFilterCancel.setOnClickListener {
            filterDialog.dismiss()
        }
        bindingDialogFilter.imageViewFilterDone.setOnClickListener {
            filterDialog.dismiss()
        }
        filterDialog.setCancelable(false)
        filterDialog.show()
    }
}