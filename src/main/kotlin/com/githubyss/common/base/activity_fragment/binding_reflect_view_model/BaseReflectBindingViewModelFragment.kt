package com.githubyss.common.base.activity_fragment.binding_reflect_view_model

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseReflectBindingViewModelFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 12:48:30
 */
abstract class BaseReflectBindingViewModelFragment<B : ViewDataBinding> : BaseReflectBindingFragment<B>(), BaseViewModelInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.lifecycleOwner = viewLifecycleOwner
    }
}
