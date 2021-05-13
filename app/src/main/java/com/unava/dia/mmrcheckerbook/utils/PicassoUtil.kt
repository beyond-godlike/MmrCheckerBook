package com.unava.dia.mmrcheckerbook.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicassoUtil {
    companion object {
        fun setPlayerIcon(imageView: ImageView, avatarUrl: String) {
            val imageUrl = StringBuilder()
                .append(avatarUrl)
                .toString()

            Picasso.with(imageView.context).load(imageUrl)
                .into(imageView)
        }
    }
}