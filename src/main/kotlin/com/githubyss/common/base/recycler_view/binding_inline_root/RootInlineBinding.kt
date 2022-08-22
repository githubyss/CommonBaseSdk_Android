package com.githubyss.common.base.recycler_view.binding_inline_root

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.githubyss.common.base.ext.inflate


/** 获取 RecyclerView 的 ViewHolder */
inline fun <reified B : ViewDataBinding> RecyclerView.Adapter<RecyclerView.ViewHolder>.bindView(parent: ViewGroup): RootInlineBindingViewHolder<B> {
    val binding by inflate<B>(parent)
    return RootInlineBindingViewHolder(binding)
}

// /** 获取 RecyclerView 的 binding */
// inline fun <reified B : ViewBinding> RecyclerView.Adapter<RecyclerView.ViewHolder>.inflate(parent: ViewGroup): Lazy<B> {
//     return lazy { inflateBindingByViewGroup<B>(parent) }
// }
