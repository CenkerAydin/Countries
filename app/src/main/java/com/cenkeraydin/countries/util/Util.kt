package com.cenkeraydin.countries.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//Extension

fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {
    //Glide

    val options  = RequestOptions().placeholder(progressDrawable)
        .error(android.R.drawable.stat_notify_error)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}
fun placeHolderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:downloadImage")
fun downloadImage(imageView: ImageView, url: String?) {
    imageView.downloadFromUrl(url, placeHolderProgressBar(imageView.context))
}