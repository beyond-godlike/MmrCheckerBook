package com.unava.dia.mmrcheckerbook.utils

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>): T {
    return ViewModelProvider(this)[viewModelClass]
}


fun setImage(imageView: ImageView, imgUrl: String) {
    Glide.with(imageView.context)
        .load(imgUrl)
        .centerCrop()
        .into(imageView)
}