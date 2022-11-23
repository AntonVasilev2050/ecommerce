package com.avvsoft2050.testecommerce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.R
import com.squareup.picasso.Picasso

class ProductDetailsAdapter(private val productDetailsImages: List<String>) :
RecyclerView.Adapter<ProductDetailsAdapter.ProductDetailsViewHolder>(){

    inner class ProductDetailsViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
                val imageViewProductDetailsItem = itemView.findViewById<ImageView>(R.id.imageViewProductDetails)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_details, parent, false)
        return ProductDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductDetailsViewHolder, position: Int) {
        val productDetailsImage = productDetailsImages[position]
        Picasso.get().load(productDetailsImage).into(holder.imageViewProductDetailsItem)
    }

    override fun getItemCount() : Int = productDetailsImages.size

}