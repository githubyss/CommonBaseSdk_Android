package com.githubyss.common.base.lifecycle.lifecycle_callbacks

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.githubyss.common.base.z_copy.logV


/**
 * ActivityLifecycleCallbacks
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2020/12/17 17:46:15
 */
open class ActivityLifecycleCallbacks private constructor() : Application.ActivityLifecycleCallbacks {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { ActivityLifecycleCallbacks::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = ActivityLifecycleCallbacks()
    }


    /** ****************************** Properties ****************************** */

    /**  */
    val activityHolder by lazy { ActivityHolder() }


    /** ****************************** Override ****************************** */

    /**
     * 对应 Activity 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param activity
     * @param savedInstanceState
     * @return
     */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val message = "${activity::class.java.simpleName} > onActivityCreated"
        logV(TAG, message)

        activityHolder.handleForegroundRestart(activity)
        activityHolder.setAnimatorsEnabled()
        activityHolder.setTopActivity(activity)
        activityHolder.currentShowActivity = activity
    }

    /**
     * 对应 Activity 的 onStart()
     *
     * @param activity
     * @return
     */
    override fun onActivityStarted(activity: Activity) {
        val message = "${activity::class.java.simpleName} > onActivityStarted"
        logV(TAG, message)

        if (activityHolder.isForeground) {
            activityHolder.setTopActivity(activity)
        }
        if (activityHolder.configCount < 0) {
            activityHolder.configCount++
        }
        else {
            activityHolder.foregroundCount++
        }
    }

    /**
     * 对应 Activity 的 onResume()
     *
     * @param activity
     * @return
     */
    override fun onActivityResumed(activity: Activity) {
        val message = "${activity::class.java.simpleName} > onActivityResumed"
        logV(TAG, message)

        if (!activityHolder.isForeground) {
            activityHolder.isForeground = true
            activityHolder.postStatus(true)
            activityHolder.sendBroadcast(activity)
        }
        activityHolder.setTopActivity(activity)
        activityHolder.currentShowActivity = activity

        activityHolder.handleForegroundGestureAuth()
        activityHolder.handleForegroundAutoLogin()
    }

    /**
     * 对应 Activity 的 onPause()
     *
     * @param activity
     * @return
     */
    override fun onActivityPaused(activity: Activity) {
        val message = "${activity::class.java.simpleName} > onActivityPaused"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onStop()
     *
     * @param activity
     * @return
     */
    override fun onActivityStopped(activity: Activity) {
        val message = "${activity::class.java.simpleName} > onActivityStopped"
        logV(TAG, message)

        // 重要，如果 Activity 的 stop 中判断应用再前后台，一定要把 super.stop() 放在第一行
        if (activity.isChangingConfigurations) {
            activityHolder.configCount--
        }
        else {
            activityHolder.foregroundCount--
            if (activityHolder.foregroundCount <= 0) {
                activityHolder.isForeground = false
                activityHolder.postStatus(false)
                activityHolder.sendBroadcast(activity)

                activityHolder.handleBackgroundRemainder(activity)
                activityHolder.handleBackgroundMoment(activity)
                activityHolder.handleBackgroundGestureAuth()
            }
        }
    }

    /**
     * 对应 Activity 的 onSaveInstanceState(outState: Bundle)
     *
     * @param activity
     * @param outState
     * @return
     */
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        val message = "${activity::class.java.simpleName} > onActivitySaveInstanceState"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onDestroy()
     *
     * @param activity
     * @return
     */
    override fun onActivityDestroyed(activity: Activity) {
        val message = "${activity::class.java.simpleName} > onActivityDestroyed"
        logV(TAG, message)

        activityHolder.activityList.remove(activity)
        activityHolder.consumeOnActivityDestroyedListener(activity)
        activityHolder.fixSoftInputLeaks(activity)
        activityHolder.checkCurrentActivity(activity)
    }
}
