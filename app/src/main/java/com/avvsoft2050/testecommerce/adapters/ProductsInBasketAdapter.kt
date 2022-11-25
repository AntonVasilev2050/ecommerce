package com.avvsoft2050.testecommerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.databinding.ItemProductInCartBinding
import com.avvsoft2050.testecommerce.entity.Basket
import com.squareup.picasso.Picasso

class ProductsInBasketAdapter(
    private val onClickAction:(Basket) -> Unit
) : ListAdapter<Basket, ProductsInBasketAdapter.ProductsInBasketViewHolder>(ProductsInBasketDiffUtil()) {


    inner class ProductsInBasketViewHolder(val binding: ItemProductInCartBinding) :
            RecyclerView.ViewHolder(binding.root) {

                fun bind(basket : Basket){
                    Picasso.get().load(basket.images).into(binding.imageViewCartItemImage)
                    binding.textViewCartItemTitle.text = basket.title
                    val oneProductPrice = basket.price
                    val productCount = 1
                    binding.textViewCartItemPrice.text = buildString {
                        append("$")
                        append(productCount * (oneProductPrice ?: 0))
                    }
                    binding.textViewCartProductCount.text = productCount.toString()
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsInBasketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductInCartBinding.inflate(inflater)
        return ProductsInBasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsInBasketViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.imageViewCartMinus.setOnClickListener { onClickAction(item) }
        holder.binding.imageViewCartPlus.setOnClickListener { onClickAction(item) }
    }
}