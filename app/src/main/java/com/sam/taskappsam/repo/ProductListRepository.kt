package com.sam.taskappsam.repo

import com.mobapps.taskapp.model.ProductListModel
import com.mobapps.taskapp.retrofit.ApiClient
import retrofit2.Call

class ProductListRepository {

    val apiInterface = ApiClient.getRetrofitService()

    fun getProductList(): Call<ArrayList<ProductListModel>>? {
        return apiInterface?.getproductlist()
    }
}