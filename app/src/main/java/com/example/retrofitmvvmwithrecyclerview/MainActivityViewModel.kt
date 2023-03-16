package com.example.retrofitmvvmwithrecyclerview

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    var liveDataList: MutableLiveData<Model>

    init {
        liveDataList = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<Model> {
       return liveDataList
    }
    fun makeAPICall(){
        val retrofitInstance = RetrofitInstance.getRetroInstance()
        val retroApiService = retrofitInstance.create(ApiService::class.java)
        val call = retroApiService.getProductsList()
        call.enqueue(object : retrofit2.Callback<Model> {
            override fun onResponse(
                call: Call<Model>,
                response: Response<Model>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                liveDataList.postValue(null)
            }


        })
    }
}