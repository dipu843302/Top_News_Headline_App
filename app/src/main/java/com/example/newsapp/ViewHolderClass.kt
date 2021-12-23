package com.example.newsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolderClass(itemView: View,onClickItem: OnClickItem) : RecyclerView.ViewHolder(itemView) {

    fun setData(articlesDTO: ArticlesDTO,onClickItem: OnClickItem){
        itemView.sourceText.text=articlesDTO.source?.name
        itemView.headlineText.text=articlesDTO.title

        Glide.with(itemView.context).load(articlesDTO.urlToImage).into(itemView.headlineImage)

        itemView.cardView.setOnClickListener {
            onClickItem.clickItems(articlesDTO,adapterPosition)
        }
    }

}