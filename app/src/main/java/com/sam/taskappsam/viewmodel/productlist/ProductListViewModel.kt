package com.sam.taskappsam.viewmodel.productlist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobapps.taskapp.model.ProductListModel
import com.sam.taskappsam.repo.ProductListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ProductListViewModel : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val productRepo: ProductListRepository = ProductListRepository()

    fun getProdList() : MutableLiveData<ArrayList<ProductListModel>>{

        val productlist = MutableLiveData<ArrayList<ProductListModel>>()
        val response = productRepo.getProductList()

        response?.enqueue(object : Callback<ArrayList<ProductListModel>?> {
            override fun onResponse(call: Call<ArrayList<ProductListModel>?>, response: Response<ArrayList<ProductListModel>?>) {
                Log.e("product ","dd ")
                productlist.postValue(response.body())
            }
            override fun onFailure(call: Call<ArrayList<ProductListModel>?>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.e("product ","errr "+t.message)
            }
        })

        return productlist
    }





}