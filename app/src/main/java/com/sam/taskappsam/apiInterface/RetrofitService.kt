package com.mobapps.taskapp.apiinterface


import com.mobapps.taskapp.model.ProductListModel
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {
    @GET("products")
    fun getproductlist(): Call<ArrayList<ProductListModel>>?

   /* @GET("products/{id}")
    fun getproductDetail(@Path("id") id: String): Call<ProductDetailResponse>?*/
}