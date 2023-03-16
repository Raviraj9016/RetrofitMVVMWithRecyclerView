package com.example.retrofitmvvmwithrecyclerview

data class Model(
    val products : ArrayList<ProductItem>
    )


data class ProductItem (
    val id : Int,
    val title : String,
    val price : Double,
    val thumbnail : String
    )