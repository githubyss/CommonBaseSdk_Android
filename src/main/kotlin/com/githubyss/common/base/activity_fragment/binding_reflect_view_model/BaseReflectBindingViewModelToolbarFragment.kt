package com.githubyss.common.base.activity_fragment.binding_reflect_view_model

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingToolbarFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseReflectBindingViewModelToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:10:27
 */
abstract class BaseReflectBindingViewModelToolbarFragment<B : ViewDataBinding> : BaseReflectBindingToolbarFragment<B>(), BaseViewModelInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindLifecycleOwner()
        bindXmlData()
        observeViewModelData()
    }

    /**  */
    override fun onDestroyView() {
        removeViewModelObserver()
        super.onDestroyView()
    }

    /**  */
    override fun bindLifecycleOwner() {
        binding.lifecycleOwner = viewLifecycleOwner
    }
}
