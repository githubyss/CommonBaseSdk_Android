package com.githubyss.common.base.frame_layout.binding_reflect

import android.content.Context
import android.util.AttributeSet
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.frame_layout.binding_reflect_root.RootReflectBindingFrameLayout


/**
 * BaseReflectBindingFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/01/04 13:34:00
 */
abstract class BaseReflectBindingFrameLayout<B : ViewBinding> @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RootReflectBindingFrameLayout<B>(context, attrs, defStyleAttr)
