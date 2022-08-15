package com.githubyss.common.base.activity_fragment.binding_inline_view_model

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseInlineBindingViewModelFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:16:59
 */
abstract class BaseInlineBindingViewModelFragment<B : ViewDataBinding>(@LayoutRes layoutId: Int) : BaseInlineBindingFragment<B>(layoutId), BaseViewModelInterface {

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
