package com.githubyss.common.base.frame_layout.binding_inline_root

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.ext.inflateBindingByViewGroup


inline fun <reified B : ViewDataBinding> FrameLayout.inflate(parent: ViewGroup): Lazy<B> {
    return lazy { inflateBindingByViewGroup<B>(parent) }
}
