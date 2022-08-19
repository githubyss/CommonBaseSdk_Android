package com.githubyss.common.base.app.z_copy

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


@set: BindingAdapter("isVisibleOrGone")
var View.isVisibleOrGone
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@set: BindingAdapter("isVisibleOrInvisible")
var View.isVisibleOrInvisible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

@BindingAdapter(value = ["path", "placeholder", "error"], requireAll = false)
fun ImageView.image(path: Any?, placeholder: Any?, error: Any?) {
    var requestOptions = RequestOptions()
    requestOptions = requestOptions.skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL)
    requestOptions = when (placeholder) {
        is Int -> requestOptions.placeholder(placeholder)
        is Drawable -> requestOptions.placeholder(placeholder)
        else -> requestOptions
    }
    requestOptions = when (error) {
        is Int -> requestOptions.error(error)
        is Drawable -> requestOptions.error(error)
        else -> requestOptions
    }

    val requestManager = Glide.with(this)
    val requestBuilder = requestManager.asDrawable().transition(DrawableTransitionOptions.withCrossFade()).apply(requestOptions)
    requestBuilder.load(path).into(this)
}
