package com.githubyss.common.base.recycler_view.binding_inline_root

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.githubyss.common.base.ext.inflateBinding


/** 获取 RecyclerView 的 ViewHolder */
inline fun <reified B : ViewDataBinding> RecyclerView.Adapter<RecyclerView.ViewHolder>.bindView(parent: ViewGroup): RootInlineBindingViewHolder<B> {
    val binding by inflateBinding<B>(parent)
    return RootInlineBindingViewHolder(binding)
}
