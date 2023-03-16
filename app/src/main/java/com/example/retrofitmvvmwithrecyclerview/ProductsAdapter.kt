package com.example.retrofitmvvmwithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitmvvmwithrecyclerview.databinding.ProductViewBinding

class ProductsAdapter(var productList : ArrayList<ProductItem>)
    : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {


    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var productViewBinding : ProductViewBinding = ProductViewBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var productView = layoutInflater.inflate(R.layout.product_view,null)
        return ProductViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       holder.productViewBinding.txtId.text ="${productList[position].id}"
        holder.productViewBinding.txtTitle.text = "${productList[position].title}"
        holder.productViewBinding.txtPrice.text = "${productList[position].price}"
        Glide.with(holder.productViewBinding.root)
            .load(productList[position].thumbnail)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .into(holder.productViewBinding.imgProduct)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

}