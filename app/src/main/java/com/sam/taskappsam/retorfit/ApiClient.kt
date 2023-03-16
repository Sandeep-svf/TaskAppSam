package com.mobapps.taskapp.retrofit
import retrofit2.Retrofit

import okhttp3.OkHttpClient
import com.google.gson.GsonBuilder
import com.mobapps.taskapp.apiinterface.RetrofitService
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
   // val client: Retrofit?
    fun getRetrofit() : Retrofit? {
            if (retrofit == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build()
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

               retrofit = Retrofit.Builder() //.baseUrl(UrlClass.BaseUrl)
                    .baseUrl(" https://fakestoreapi.com/")
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                   // .addConverterFactory(LenientGsonConverterFactory.create(gson))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit
        }
    fun getRetrofitService() : RetrofitService? {
        return getRetrofit()?.create(RetrofitService::class.java)
    }
}