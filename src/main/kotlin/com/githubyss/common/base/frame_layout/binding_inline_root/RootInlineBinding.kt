package com.githubyss.common.base.frame_layout.binding_inline_root

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.ext.binding_inflate.inflateBindingByViewGroup


inline fun <reified B : ViewBinding> FrameLayout.inflate(parent: ViewGroup): Lazy<B> {
    return lazy { inflateBindingByViewGroup(parent) }
}
