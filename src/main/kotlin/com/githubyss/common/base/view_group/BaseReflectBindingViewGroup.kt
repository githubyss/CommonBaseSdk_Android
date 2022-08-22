package com.githubyss.common.base.view_group

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.frame_layout.binding_reflect_root.RootReflectBindingFrameLayout


/**
 * BaseReflectBindingViewGroup
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 16:58:35
 */
abstract class BaseReflectBindingViewGroup<B : ViewDataBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RootReflectBindingViewGroup<B>(context, attrs, defStyleAttr)
