package com.example.rickandmortyapi.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String) {
    Glide
        .with(this)
        .load(uri)
        .into(this)
}