package com.githubyss.common.base.activity_fragment.interface_default


/**
 * BaseLifecycleInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/29 21:38:09
 */
interface BaseLifecycleInterface {
    /** 注册生命周期监听 */
    fun registerLifecycle() {}

    /** 反注册生命周期监听 */
    fun unregisterLifecycle() {}
}
