package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.githubyss.common.base.lifecycle.lifecycle_callbacks.ActivityHolder
import com.githubyss.common.base.z_copy.logV


/**
 * ActivityLifecycleObserverDefault
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/11 15:39:15
 */
open class ActivityLifecycleObserverDefault private constructor() : DefaultLifecycleObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { ActivityLifecycleObserverDefault::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = ActivityLifecycleObserverDefault()
    }


    /** ****************************** Properties ****************************** */

    /**  */
    val activityHolder by lazy { ActivityHolder() }


    /** ****************************** Override ****************************** */

    /**
     * 对应 Activity 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param
     * @return
     */
    override fun onCreate(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onCreate"
        logV(TAG, message)

        val activity = owner as AppCompatActivity

        activityHolder.handleForegroundRestart(activity)
        activityHolder.setAnimatorsEnabled()
        activityHolder.setTopActivity(activity)
        activityHolder.currentShowActivity = activity
    }

    /**
     * 对应 Activity 的 onStart()
     *
     * @param
     * @return
     */
    override fun onStart(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStart"
        logV(TAG, message)

        val activity = owner as AppCompatActivity

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
     * @param
     * @return
     */
    override fun onResume(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onResume"
        logV(TAG, message)

        val activity = owner as AppCompatActivity

        if (!activityHolder.isForeground) {
            activityHolder.isForeground = true
            activityHolder.postStatus(true)
            activityHolder.sendBroadcast(activity)
        }
        activityHolder.setTopActivity(activity)
        activityHolder.currentShowActivity = activity

        activityHolder.handleForegroundGestureAuth()
        activityHolder.handleForegroundAutoLogin()

        logV(TAG, "topActivity: ${activityHolder.getTopActivity()?.javaClass?.simpleName}")
        logV(TAG, "currentShowActivity: ${activityHolder.currentShowActivity?.javaClass?.simpleName}")
    }

    /**
     * 对应 Activity 的 onPause()
     *
     * @param
     * @return
     */
    override fun onPause(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onPause"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onStop()
     *
     * @param
     * @return
     */
    override fun onStop(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStop"
        logV(TAG, message)

        val activity = owner as AppCompatActivity

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
     * 对应 Activity 的 onDestroy()
     *
     * @param
     * @return
     */
    override fun onDestroy(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onDestroy"
        logV(TAG, message)

        val activity = owner as AppCompatActivity

        activityHolder.activityList.remove(activity)
        activityHolder.consumeOnActivityDestroyedListener(activity)
        activityHolder.fixSoftInputLeaks(activity)
        activityHolder.checkCurrentActivity(activity)
    }
}
