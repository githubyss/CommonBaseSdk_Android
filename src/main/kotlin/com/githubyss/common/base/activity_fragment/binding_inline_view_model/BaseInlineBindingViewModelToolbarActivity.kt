package com.githubyss.common.base.activity_fragment.binding_inline_view_model

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingToolbarActivity


/**
 * BaseInlineBindingViewModelToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:12:26
 */
abstract class BaseInlineBindingViewModelToolbarActivity<B : ViewDataBinding> : BaseInlineBindingToolbarActivity<B>() {

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


    /** ****************************** Abstract ****************************** */

    /** 绑定 Activity LifecycleOwner 到 ViewDataBinding */
    abstract fun bindLifecycleOwner()

    /** 绑定 ViewModel 到 ViewDataBinding */
    abstract fun bindXmlData()

    /** 观察 ViewModel 的数据变化 */
    abstract fun observeViewModelData()

    /** 移除 ViewModel 的数据观察 */
    abstract fun removeViewModelObserver()
}
