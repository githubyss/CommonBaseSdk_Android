package com.githubyss.common.base.layout.frame_layout.binding_inline

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding


/**
 * BaseInlineBindingFrameLayout
 *
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/01/04 14:57:34
 */
@Deprecated("Inline 方案的 inflate 函数无法渲染出来布局")
abstract class BaseInlineBindingFrameLayout<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RootInlineBindingFrameLayout<B>(context, attrs, defStyleAttr)
