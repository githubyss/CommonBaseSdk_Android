package com.githubyss.common.base.activity_fragment.interface_default


/**
 * BaseBroadcastReceiverInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/29 21:34:46
 */
interface BaseBroadcastReceiverInterface {
    /** 动态广播最好在 Activity 的 onResume() 注册、onPause() 注销。 */
    /** 注册广播接收器 */
    fun registerReceiver() {}

    /** 反注册广播接收器 */
    fun unregisterReceiver() {}
}
