package com.example.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val list: List<ArticlesDTO>, private val onClickItem: OnClickItem) : RecyclerView.Adapter<ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolderClass(view,onClickItem)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val data = list[position]
        holder.setData(data,onClickItem)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}