package com.avvsoft2050.testecommerce.adapters

import androidx.recyclerview.widget.DiffUtil
import com.avvsoft2050.testecommerce.entity.HomeStore

class HomeStoreDiffUtil : DiffUtil.ItemCallback<HomeStore>(){
    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem == newItem
    }
}