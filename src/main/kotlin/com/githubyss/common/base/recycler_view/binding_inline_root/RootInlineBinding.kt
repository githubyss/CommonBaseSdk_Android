package com.githubyss.common.base.recycler_view.binding_inline_root

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.ext.inflateBindingByViewGroup


/**
 * 通过 ViewGroup 获取 ViewHolder
 *
 * @param parent ViewGroup
 * @return ViewHolder 实例
 */
inline fun <reified B : ViewBinding> RecyclerView.Adapter<RecyclerView.ViewHolder>.bindView(parent: ViewGroup): RootInlineBindingViewHolder<B> {
    val binding by inflate<B>(parent)
    return RootInlineBindingViewHolder(binding)
}

inline fun <reified B : ViewBinding> RecyclerView.Adapter<RecyclerView.ViewHolder>.inflate(parent: ViewGroup): Lazy<B> {
    return inflateBindingByViewGroup(parent)
}
