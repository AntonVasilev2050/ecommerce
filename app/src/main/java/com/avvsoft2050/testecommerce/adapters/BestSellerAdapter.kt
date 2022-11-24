package com.avvsoft2050.testecommerce.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.R
import com.avvsoft2050.testecommerce.databinding.ItemBestSellerBinding
import com.avvsoft2050.testecommerce.entity.BestSeller
import com.squareup.picasso.Picasso

class BestSellerAdapter(
    private val onClickAction: (BestSeller) -> Unit
) : ListAdapter<BestSeller, BestSellerAdapter.BestSellerViewHolder>(BestSellerDiffUtil()) {

    inner class BestSellerViewHolder(val binding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bestSeller: BestSeller) {
            Picasso.get().load(bestSeller.picture).into(binding.imageViewPicture)
            binding.textViewDiscountPrice.text = buildString {
                append("$")
                append(bestSeller.discountPrice.toString())
            }
            val textViewPrice = binding.textViewPrice
            textViewPrice.text = buildString {
                append("$")
                append(bestSeller.priceWithoutDiscount.toString())
            }
            textViewPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.textViewTitle.text = bestSeller.title
            if (bestSeller.isFavorites == true){
                binding.imageViewFavorite.setImageResource(R.drawable.favorite)
            }else{
                binding.imageViewFavorite.setImageResource(R.drawable.not_favorite)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerBinding.inflate(inflater)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onClickAction(item)
        }
    }
}