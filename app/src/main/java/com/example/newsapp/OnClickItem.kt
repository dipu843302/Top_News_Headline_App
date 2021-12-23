package com.example.newsapp

import android.content.Context

interface OnClickItem {

    fun clickItems(articlesDTO:ArticlesDTO,position:Int)
}