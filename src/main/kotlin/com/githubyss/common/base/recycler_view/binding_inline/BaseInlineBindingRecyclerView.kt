package com.githubyss.common.base.recycler_view.binding_inline

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * BaseInlineBindingRecyclerView
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:57:47
 */
abstract class BaseInlineBindingRecyclerView<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr)
