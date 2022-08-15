package com.githubyss.common.base.activity_fragment.binding_reflect_view_model

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingActivity
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseReflectBindingViewModelActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 12:37:54
 */
abstract class BaseReflectBindingViewModelActivity<B : ViewDataBinding> : BaseReflectBindingActivity<B>(), BaseViewModelInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindLifecycleOwner()
        bindXmlData()
        observeViewModelData()
    }

    /**  */
    override fun onDestroy() {
        removeViewModelObserver()
        super.onDestroy()
    }

    /**  */
    override fun bindLifecycleOwner() {
        binding.lifecycleOwner = this
    }
}
