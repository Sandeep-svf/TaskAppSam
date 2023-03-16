package com.mobapps.taskapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ProductListModel (
    @SerializedName("id")
     var id: Int? = null,

    @SerializedName("title")
     var title: String? = null,

    @SerializedName("price")
     var price: Double? = null,

    @SerializedName("description")
     var description: String? = null,



    @SerializedName("category")
     var category: String? = null,

    @SerializedName("image")
     var image: String? = null,

   /* @SerializedName("rating")
     var ratingModel: RatingModel? = null*/
)