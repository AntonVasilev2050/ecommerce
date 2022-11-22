package com.avvsoft2050.testecommerce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.databinding.ItemHotSalesBinding
import com.avvsoft2050.testecommerce.entity.HomeStore
import com.squareup.picasso.Picasso

class HotSalesAdapter(
    private val onClickAction: (HomeStore) -> Unit
) : ListAdapter<HomeStore, HotSalesAdapter.HotSalesViewHolder>(HomeStoreDiffUtil()) {

    inner class HotSalesViewHolder(val binding: ItemHotSalesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(homeStore: HomeStore) {
            Picasso.get().load(homeStore.picture).into(binding.imageViewHotSalesItem)
            binding.textViewItemBrand.text = homeStore.title
            binding.textViewItemDescription.text = homeStore.subtitle
            if (homeStore.isNew == true) {
                binding.imageViewNew.visibility = View.VISIBLE
            } else {
                binding.imageViewNew.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotSalesBinding.inflate(inflater)
        return HotSalesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.buttonBuyNow.setOnClickListener {
            onClickAction(item)
        }
    }
}