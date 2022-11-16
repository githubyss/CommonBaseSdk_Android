package com.githubyss.common.base.lifecycle


/**
 * LifecycleConstant
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 17:48:46
 */
object LifecycleConstant {
/** 权限 Activity 类名 */
    const val PERMISSION_ACTIVITY_CLASS_NAME: String = "com.githubyss.common.util.PermissionUtils\$PermissionActivity"

    // 程序前后台切换的广播
    const val INTENT_ACTION_IS_FOREGROUND = "com.githubyss.common.intent.action.IS_FOREGROUND"

    // 锁屏延迟时间（毫秒）
    const val LOCK_DELAY = 5 * 60 * 1000.toLong()

    // 自动登录延迟时间（毫秒）
    const val AUTO_LOGON_DELAY = 14 * 60 * 1000.toLong()
}
