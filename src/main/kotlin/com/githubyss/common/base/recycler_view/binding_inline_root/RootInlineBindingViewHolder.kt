package com.githubyss.common.base.recycler_view.binding_inline_root

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * RootInlineBindingViewHolder
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/08 09:59:43
 */
class RootInlineBindingViewHolder<B : ViewBinding>(binding: B) : RecyclerView.ViewHolder(binding.root) {
    lateinit var binding: B
}
