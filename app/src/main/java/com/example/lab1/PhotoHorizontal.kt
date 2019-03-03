package com.example.lab1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_photo_horizontal.*

class PhotoHorizontal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_horizontal)

        val bundle = intent.extras

        imgPhotoHorizontal.setImageResource(bundle.getInt("image"))
    }

}