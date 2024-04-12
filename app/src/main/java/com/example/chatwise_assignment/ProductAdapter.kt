package com.example.chatwise_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        private val productTitleTextView: TextView = itemView.findViewById(R.id.productTitleTextView)
        private val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)

        fun bind(product: Product) {

            Glide.with(itemView)
                .load(product.imageUrl)
                .placeholder(R.drawable.place_holder)
                .into(productImageView)


            productTitleTextView.text = product.title
            productDescriptionTextView.text = product.description
        }
    }
}
