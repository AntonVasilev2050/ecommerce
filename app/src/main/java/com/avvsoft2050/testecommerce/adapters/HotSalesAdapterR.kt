package com.avvsoft2050.testecommerce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avvsoft2050.testecommerce.R
import com.avvsoft2050.testecommerce.entity.HomeStore
import com.squareup.picasso.Picasso

class HotSalesAdapterR(private val listOfHomeStore: List<HomeStore>) :
    RecyclerView.Adapter<HotSalesAdapterR.HotSalesViewHolder>() {

    var onHomeStoreClickListener: OnHomeStoreClickListener? = null

    inner class HotSalesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imageViewHotSalesItem = itemView.findViewById<ImageView>(R.id.imageViewHotSalesItem)
        val textViewItemBrand = itemView.findViewById<TextView>(R.id.textViewItemBrand)
        val textViewItemDescription = itemView.findViewById<TextView>(R.id.textViewItemDescription)
        val imageViewNew = itemView.findViewById<ImageView>(R.id.imageViewNew)
        val buttonBuyNow = itemView.findViewById<Button>(R.id.buttonBuyNow)
    }

    interface OnHomeStoreClickListener{
        fun onBuyNowClick(homeStore: HomeStore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hot_sales, parent, false)
        return HotSalesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        val homeStore = listOfHomeStore[position]
        Picasso.get().load(homeStore.picture).into(holder.imageViewHotSalesItem)
        holder.textViewItemBrand.text = homeStore.title
        holder.textViewItemDescription.text = homeStore.subtitle
        if (homeStore.isNew == true) {
            holder.imageViewNew.visibility = View.VISIBLE
        } else {
            holder.imageViewNew.visibility = View.INVISIBLE
        }
        holder.buttonBuyNow.setOnClickListener {
            onHomeStoreClickListener?.onBuyNowClick(homeStore)
        }
    }

    override fun getItemCount(): Int = listOfHomeStore.size
}