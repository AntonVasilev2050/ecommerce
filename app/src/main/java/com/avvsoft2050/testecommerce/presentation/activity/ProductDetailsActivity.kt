package com.avvsoft2050.testecommerce.presentation.activity

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.avvsoft2050.testecommerce.R
import com.avvsoft2050.testecommerce.adapters.ProductDetailsAdapter
import com.avvsoft2050.testecommerce.databinding.ActivityProductDetailsBinding
import com.avvsoft2050.testecommerce.presentation.viewmodel.CartViewModel
import com.avvsoft2050.testecommerce.presentation.viewmodel.ProductDetailsViewModel

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private lateinit var cartViewModel: CartViewModel
    private lateinit var adapterProductDetails: ProductDetailsAdapter
    private lateinit var viewPagerProductDetails: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPagerProductDetails = binding.viewPagerProductDetails
        productDetailsViewModel = ViewModelProvider(this)[ProductDetailsViewModel::class.java]
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        viewPagerProductDetails.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((20 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPagerProductDetails.setPageTransformer(compositePageTransformer)
        binding.imageViewProductDetailsCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        productDetailsViewModel.productDetails.observe(this) {
            adapterProductDetails = ProductDetailsAdapter(it.images)
            viewPagerProductDetails.adapter = adapterProductDetails
            binding.apply {
                imageViewProductDetailsBack.setOnClickListener {
                    finish()
                }
                textViewProductDetailsTitle.text = it.title
                ratingBar.rating = it.rating?.toFloat() ?: 0f
                textViewProductDetailsCpu.text = it.cpu
                textViewProductDetailsCamera.text = it.camera
                textViewProductDetailsSsd.text = it.ssd
                textViewProductDetailsSd.text = it.sd
                buttonProductDetailsCapacity128.text = buildString {
                    append(it.capacity?.get(0) ?: "no data")
                    append(" GB")
                }
                buttonProductDetailsCapacity256.text = buildString {
                    append(it.capacity?.get(1) ?: "no data")
                    append(" GB")
                }
                buttonProductDetailsAddToCart.text = buildString {
                    append("Add to Cart          $")
                    append(it.price)
                }
            }
        }

        cartViewModel.cart.observe(this){
            val productsInBasketCount = it.basket.size
        }
    }
}