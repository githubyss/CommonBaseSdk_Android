package com.githubyss.common.base.activity_fragment.binding_inline_view_model

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingActivity
import com.githubyss.common.base.activity_fragment.interface_default.BaseViewModelInterface


/**
 * BaseInlineBindingViewModelActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:10:15
 */
abstract class BaseInlineBindingViewModelActivity<B : ViewDataBinding> : BaseInlineBindingActivity<B>(), BaseViewModelInterface {

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
