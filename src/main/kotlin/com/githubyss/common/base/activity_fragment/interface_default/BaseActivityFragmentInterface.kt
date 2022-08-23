package com.githubyss.common.base.activity_fragment.interface_default


/**
 * BaseActivityFragmentInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/11 15:57:16
 */
interface BaseActivityFragmentInterface {
    /** 初始化 UI */
    fun setupUi() {}

    /** 初始化数据 */
    fun setupData() {}

    /** 监听注册 */
    fun doRegister() {}

    /** 监听反注册 */
    fun doUnregister() {}
}
