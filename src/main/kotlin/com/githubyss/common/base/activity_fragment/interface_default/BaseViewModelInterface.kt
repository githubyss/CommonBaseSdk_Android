package com.githubyss.common.base.activity_fragment.interface_default


/**
 * BaseViewModelInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/12 14:37:11
 */
interface BaseViewModelInterface {
    /** 绑定 Activity LifecycleOwner 到 ViewDataBinding */
    fun bindLifecycleOwner() {}

    /** 绑定 ViewModel 到 ViewDataBinding */
    fun bindXmlData() {}

    /** 观察 ViewModel 的数据变化 */
    fun observeViewModelData() {}

    /** 移除 ViewModel 的数据观察 */
    fun removeViewModelObserver() {}
}
