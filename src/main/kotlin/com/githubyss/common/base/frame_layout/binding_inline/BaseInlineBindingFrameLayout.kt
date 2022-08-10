package com.githubyss.common.base.frame_layout.binding_inline

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.frame_layout.binding_inline_root.RootInlineBindingFrameLayout


/**
 * BaseInlineBindingFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/01/04 14:57:34
 */
abstract class BaseInlineBindingFrameLayout<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RootInlineBindingFrameLayout<B>(context, attrs, defStyleAttr)
