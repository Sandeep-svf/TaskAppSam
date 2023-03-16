package com.sam.taskappsam.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobapps.taskapp.model.ProductListModel
import com.sam.taskappsam.R
import com.sam.taskappsam.adapter.ProductListAdapter
import com.sam.taskappsam.viewmodel.productlist.ProductListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        val recyclerview = findViewById<RecyclerView>(R.id.productsList_recyclerview)

        val servicesLayoutManager : RecyclerView.LayoutManager = GridLayoutManager(
            this@MainActivity,2)
        recyclerview.setLayoutManager(servicesLayoutManager)
        recyclerview.setItemAnimator(DefaultItemAnimator())

        viewModel.getProdList().observe(this, Observer {
            it.let {

                val productListAdapter =  ProductListAdapter(it){productListModel->
                    Log.e("chk_size","        "+productListModel?.id)
                   /* intent = Intent(this@MainActivity, ProductDetail::class.java)
                    intent.putExtra("product_id",productListModel?.id)
                    startActivity(intent)*/

            }
                recyclerview.adapter = productListAdapter
        }

        })
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}