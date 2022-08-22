package com.githubyss.common.base.view_group.binding_reflect

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding


/**
 * BaseReflectBindingViewGroup
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 16:58:35
 */
@Deprecated("ViewGroup 方案无法渲染出来布局")
abstract class BaseReflectBindingViewGroup<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RootReflectBindingViewGroup<B>(context, attrs, defStyleAttr)
