package com.avvsoft2050.testecommerce.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.adapters.ProductsInBasketAdapter
import com.avvsoft2050.testecommerce.databinding.ActivityCartBinding
import com.avvsoft2050.testecommerce.presentation.viewmodel.CartViewModel

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var cartViewModel: CartViewModel
    private lateinit var adapterProductsInBasket: ProductsInBasketAdapter
    private lateinit var recyclerViewCart: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewCart = binding.recyclerViewCart
        cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        adapterProductsInBasket = ProductsInBasketAdapter(
            onClickAction = {

            }
        )

        cartViewModel.cart.observe(this){
            binding.textViewCartTotal.text = buildString {
                append("$")
                append(it.total.toString())
                append(" us")
            }
            binding.textViewCartDelivery.text = it.delivery
        }

        cartViewModel.baskets.observe(this) {
            adapterProductsInBasket.submitList(it)
            recyclerViewCart.adapter = adapterProductsInBasket
        }
    }
}