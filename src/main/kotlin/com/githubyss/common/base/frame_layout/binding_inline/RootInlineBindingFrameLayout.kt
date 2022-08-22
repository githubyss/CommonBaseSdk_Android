package com.githubyss.common.base.frame_layout.binding_inline

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
@Deprecated("Inline 方案的 inflate 函数无法渲染出来布局")
abstract class RootInlineBindingFrameLayout<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseFrameLayout(context, attrs, defStyleAttr) {
    lateinit var binding: B
}
