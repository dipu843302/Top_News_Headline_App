package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),OnClickItem{

    private var list= listOf<ArticlesDTO>()
    private val country = "in"
    private val key ="cdf0c14374c54a3e9089589149d5e8aa"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiServices =Network.getRetrofitInstance().create(ApiServices::class.java)
        apiServices.getUserDetails(country,key).enqueue(object : Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                list = response.body()?.articles as List<ArticlesDTO>
                setRecyclerView()
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                Toast.makeText(applicationContext,"No data",Toast.LENGTH_SHORT).show()
            }

        }
        )

    }

    private fun setRecyclerView(){
        val adapterClass =AdapterClass(list,this)
        recyclerview.adapter=adapterClass
        recyclerview.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun clickItems(articlesDTO: ArticlesDTO, position: Int) {
        intent= Intent(this,MainActivity2::class.java)
        intent.putExtra("image",articlesDTO.urlToImage)
        intent.putExtra("description",articlesDTO.title)
        intent.putExtra("content",articlesDTO.description)
        intent.putExtra("publish",articlesDTO.publishedAt)
        intent.putExtra("source",articlesDTO.source?.name)
        startActivity(intent)
    }
}