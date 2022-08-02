package com.unava.dia.mmrcheckerbook.utils


import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.mmrcheckerbook.glideBypass.GlideApp


fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>): T {
    return ViewModelProvider(this)[viewModelClass]
}


fun setImage(imageView: ImageView, imgUrl: String) {

    GlideApp.with(imageView.context)
        .load(imgUrl)
        .centerCrop()
        .into(imageView)
}