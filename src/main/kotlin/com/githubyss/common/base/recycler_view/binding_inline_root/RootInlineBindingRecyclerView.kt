package com.githubyss.common.base.recycler_view.binding_inline_root

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.recycler_view.classical.BaseRecyclerView


/**
 * RootInlineBindingRecyclerView
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:59:41
 */
abstract class RootInlineBindingRecyclerView<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseRecyclerView(context, attrs, defStyleAttr) {
    lateinit var binding: B
}
