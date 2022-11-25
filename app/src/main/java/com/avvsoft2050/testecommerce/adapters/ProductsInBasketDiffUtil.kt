package com.avvsoft2050.testecommerce.adapters

import androidx.recyclerview.widget.DiffUtil
import com.avvsoft2050.testecommerce.entity.Basket

class ProductsInBasketDiffUtil : DiffUtil.ItemCallback<Basket>() {
    override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem == newItem
    }
}