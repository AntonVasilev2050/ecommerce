package com.avvsoft2050.testecommerce.adapters

import androidx.recyclerview.widget.DiffUtil
import com.avvsoft2050.testecommerce.entity.BestSeller

class BestSellerDiffUtil : DiffUtil.ItemCallback<BestSeller>() {
    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem == newItem
    }
}