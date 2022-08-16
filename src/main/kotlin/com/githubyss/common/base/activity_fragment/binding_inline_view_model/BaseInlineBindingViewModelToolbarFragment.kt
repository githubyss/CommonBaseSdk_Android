package com.githubyss.common.base.activity_fragment.binding_inline_view_model

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingToolbarFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseInlineBindingViewModelToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:17:48
 */
abstract class BaseInlineBindingViewModelToolbarFragment<B : ViewDataBinding>(@LayoutRes layoutId: Int) : BaseInlineBindingToolbarFragment<B>(layoutId), BaseViewModelInterface {

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
