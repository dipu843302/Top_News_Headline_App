package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val info:Bundle?=intent.extras

        if (info != null) {
            textViewDescription.text= info.getCharSequence("description")
            textviewContent.text=info.getCharSequence("content")
            textViewSource.text=info.getCharSequence("source")
            textViewPublish.text = info.getCharSequence("publish")
            Glide.with(applicationContext).load(info.getString("image")).into(imageViewDetails)

        }

    }
}