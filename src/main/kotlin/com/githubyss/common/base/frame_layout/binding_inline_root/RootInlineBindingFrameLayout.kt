package com.githubyss.common.base.frame_layout.binding_inline_root

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.frame_layout.classical.BaseFrameLayout


/**
 * RootInlineBindingFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:34:20
 */
abstract class RootInlineBindingFrameLayout<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseFrameLayout(context, attrs, defStyleAttr) {
    lateinit var binding: B
}
