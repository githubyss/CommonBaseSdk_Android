package com.githubyss.common.base.activity_fragment.binding_reflect_view_model

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_reflect_root.RootReflectBindingDialogFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseReflectBindingViewModelDialogFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/25 16:43:48
 */
abstract class BaseReflectBindingViewModelDialogFragment<B : ViewDataBinding> : RootReflectBindingDialogFragment<B>(), BaseViewModelInterface {

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
