package com.githubyss.common.base.lifecycle.lifecycle_callbacks

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.githubyss.common.base.lifecycle.LifecycleConstant
import java.lang.reflect.InvocationTargetException
import java.util.*


/**
 * ActivityHolder
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/12 17:14:50
 */
class ActivityHolder {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { ActivityHolder::class.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /** Is app in foreground. */
    var isForeground = false

    /** Activity count in foreground. */
    var foregroundCount = 0

    /** Activity changing configurations count. */
    var configCount = 0

    /** The top activity */
    var currentShowActivity: Activity? = null

    /** The activity list */
    val activityList by lazy { LinkedList<Activity>() }

    /** The activity stack */
    val activityStack by lazy { Stack<Activity>() }

    /** Gesture timer opened flag */
    private var isGestureTimerOpened = false

    /** User leave moment */
    private var userLeaveMoment = 0

    /** Auto logon moment after leave */
    private var autoLogonLeaveMoment = 0L

    /** The status listener map */
    private val statusListenerMap by lazy { HashMap<Any?, OnAppStatusChangedListener?>() }

    /** The destroyed listener map */
    private val destroyedListenerMap by lazy { HashMap<Activity?, Set<OnActivityDestroyedListener?>?>() }


    /** ****************************** Functions ****************************** */

    /**  */
    val activityNum
        get() = activityList.size

    /**  */
    fun getTopActivity(): Activity? {
        if (activityList.isNotEmpty()) {
            val topActivity = activityList.last
            if (topActivity != null) {
                return topActivity
            }
        }

        val topActivityByReflect = getTopActivityByReflect()
        if (topActivityByReflect != null) {
            setTopActivity(topActivityByReflect)
        }
        return topActivityByReflect
    }

    /**  */
    internal fun setTopActivity(activity: Activity?) {
        activity ?: return

        val activityName = activity.javaClass.name
        if (LifecycleConstant.PERMISSION_ACTIVITY_CLASS_NAME == activityName) return

        if (activityList.contains(activity)) {
            if (activityList.last != activity) {
                activityList.remove(activity)
                activityList.addLast(activity)
                println("$TAG ?????????????????? activityName: ${activity::class.java.name}")
            }
        }
        else {
            activityList.addLast(activity)
            println("$TAG ???????????? activityName: ${activity::class.java.name}")
        }
    }

    /**  */
    private fun getTopActivityByReflect(): Activity? {
        try {
            @SuppressLint("PrivateApi")
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val currentActivityThreadMethod = activityThreadClass.getMethod("currentActivityThread")
                .invoke(null)
            val activityListField = activityThreadClass.getDeclaredField("mActivityList")
            activityListField.isAccessible = true
            val activities = activityListField[currentActivityThreadMethod] as Map<*, *>
            for (activityRecord in activities.values) {
                if (activityRecord != null) {
                    val activityRecordClass: Class<Any> = activityRecord.javaClass
                    val pausedField = activityRecordClass.getDeclaredField("paused")
                    pausedField.isAccessible = true
                    if (!pausedField.getBoolean(activityRecord)) {
                        val activityField = activityRecordClass.getDeclaredField("activity")
                        activityField.isAccessible = true
                        return activityField[activityRecord] as Activity
                    }
                }
            }
        }
        catch (e: ClassNotFoundException) {
            println("$TAG $e")
        }
        catch (e: IllegalAccessException) {
            println("$TAG $e")
        }
        catch (e: InvocationTargetException) {
            println("$TAG $e")
        }
        catch (e: NoSuchMethodException) {
            println("$TAG $e")
        }
        catch (e: NoSuchFieldException) {
            println("$TAG $e")
        }
        return null
    }

    /**  */
    fun addOnAppStatusChangedListener(`object`: Any?, listener: OnAppStatusChangedListener?) {
        statusListenerMap[`object`] = listener
    }

    /**  */
    fun removeOnAppStatusChangedListener(`object`: Any?) {
        statusListenerMap.remove(`object`)
    }

    /**  */
    fun removeOnActivityDestroyedListener(activity: Activity?) {
        if (activity == null) return
        destroyedListenerMap.remove(activity)
    }

    /**  */
    fun addOnActivityDestroyedListener(activity: Activity?, listener: OnActivityDestroyedListener?) {
        activity ?: return
        listener ?: return

        val listeners: MutableSet<OnActivityDestroyedListener?>?
        if (!destroyedListenerMap.containsKey(activity)) {
            listeners = HashSet()
            destroyedListenerMap[activity] = listeners
        }
        else {
            listeners = destroyedListenerMap[activity] as MutableSet
            if (listeners.contains(listener)) return
        }
        listeners.add(listener)
    }

    /**  */
    internal fun postStatus(isForeground: Boolean) {
        if (statusListenerMap.isEmpty()) return

        for (onAppStatusChangedListener in statusListenerMap.values) {
            if (onAppStatusChangedListener == null) return
            if (isForeground) {
                onAppStatusChangedListener.onForeground()
            }
            else {
                onAppStatusChangedListener.onBackground()
            }
        }
    }

    /**
     * Send broadcast in application.
     *
     * @param activity The activity.
     */
    internal fun sendBroadcast(activity: Activity?) {
        activity ?: return

        val intent = Intent(LifecycleConstant.INTENT_ACTION_IS_FOREGROUND)
        intent.putExtra("isForeground", isForeground)
        LocalBroadcastManager.getInstance(activity).sendBroadcast(intent)
    }

    /**
     * Set animators enabled.
     */
    @SuppressLint("SoonBlockedPrivateApi")
    internal fun setAnimatorsEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && ValueAnimator.areAnimatorsEnabled()) return

        try {
            val sDurationScaleField = ValueAnimator::class.java.getDeclaredField("sDurationScale")
            sDurationScaleField.isAccessible = true
            val sDurationScale = sDurationScaleField[null] as Float
            if (sDurationScale == 0f) {
                sDurationScaleField[null] = 1f
                println("$TAG setAnimatorsEnabled: Animators are enabled now!")
            }
        }
        catch (e: NoSuchFieldException) {
            println("$TAG $e")
        }
        catch (e: IllegalAccessException) {
            println("$TAG $e")
        }
    }

    /**  */
    internal fun consumeOnActivityDestroyedListener(activity: Activity?) {
        activity ?: return

        val iterator: MutableIterator<MutableMap.MutableEntry<Activity?, Set<OnActivityDestroyedListener?>?>> = destroyedListenerMap.entries.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.key === activity) {
                val value = entry.value
                if (value != null) {
                    for (listener in value) {
                        listener?.onActivityDestroyed(activity)
                    }
                }
                iterator.remove()
            }
        }
    }

    /**  */
    internal fun fixSoftInputLeaks(activity: Activity?) {
        activity ?: return

        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val leakViews = arrayOf("mLastSrvView", "mCurRootView", "mServedView", "mNextServedView")
        for (leakView in leakViews) {
            try {
                val leakViewField = InputMethodManager::class.java.getDeclaredField(leakView)
                if (!leakViewField.isAccessible) {
                    leakViewField.isAccessible = true
                }
                val obj = leakViewField[imm] as? View ?: continue
                if (obj.rootView === activity.window.decorView.rootView) {
                    leakViewField[imm] = null
                }
            }
            catch (ignore: Throwable) {
                println("$TAG $ignore")
            }
        }
    }

    /**  */
    internal fun checkCurrentActivity(activity: Activity) {
        // ??????????????????????????????????????????????????? onCreate?????????????????????????????? onDestroy
        // ??????????????????????????????????????? onResume???????????????????????????????????? onDestroy
        // ???????????? activity ??????????????????????????????????????????????????????????????????????????????
        if (currentShowActivity === activity) {
            currentShowActivity = null
        }
    }

    /** ??????????????????????????? */
    // fun isGestureExist(): Boolean {
    //     if (!activityList.isEmpty()) {
    //         for (activity in activityList) {
    //             if (activity is GestureLogonActivity) {
    //                 return true
    //             }
    //         }
    //     }
    //     return false
    // }

    /** ??????????????????????????? */
    // fun isSplashExist(): Boolean {
    //     if (!activityList.isEmpty()) {
    //         for (activity in activityList) {
    //             if (activity is SplashActivity) {
    //                 return true
    //             }
    //         }
    //     }
    //     return false
    // }

    /** ??????????????????????????????????????? */
    // fun isOverTime(): Boolean {
    //     if (isGestureTimerOpened) {
    //         val currentTime = SystemClock.elapsedRealtime()
    //         if (currentTime - userLeaveMoment > LOCK_DELAY) {
    //             // if (isLogon()) {
    //             isGestureTimerOpened = false
    //             return true
    //             // }
    //         }
    //     }
    //     return false
    // }

    /** ????????????????????????????????????????????????????????? */
    internal fun handleForegroundRestart(activity: Activity) {
        // if (activity != null && activity !is SplashActivity && EPApp.getApp().isColdStart && savedInstanceState != null) {
        //     // ??????????????????????????????????????????Splash
        //     if (activity is LauncherActivity) {
        //         val intent = Intent(activity, SplashActivity::class.java)
        //         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        //         activity.startActivity(intent)
        //     }
        //     activity.finish()
        //     StaticVariable.IS_EXIT_APPLICATION = true
        //     return
        // }
    }

    /** ?????????????????????????????????????????? */
    internal fun handleForegroundGestureAuth() {
        // ??????????????????????????????????????????????????????????????????????????????
        // if (isGestureTimerOpened) {
        //     // ??????????????????
        //     val userBackMoment = SystemClock.elapsedRealtime()
        //     val userLeaveDuration = userBackMoment - userLeaveMoment
        //     // ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //     if ((userLeaveDuration > LOCK_DELAY)) {
        //         if (isLogon()) {
        //             userLeaveMoment = userBackMoment
        //             // TODO ????????????????????????
        //         }
        //     }
        //     // ??????????????????????????????
        //     isGestureTimerOpened = false
        // }
    }

    /** ???????????????????????????????????? */
    internal fun handleForegroundAutoLogin() {
        // ????????????????????????0??????????????????????????????????????????????????????????????????????????????????????????????????????????????????;
        // ???????????????????????????
        // ??????????????????
        // if (autoLogonLeaveMoment != 0L && activity != null) {
        //     val autoLogonBackMoment = SystemClock.elapsedRealtime()
        //     val autoLogonLeaveDuration = autoLogonBackMoment - autoLogonLeaveMoment
        //     if (activity !is SplashActivity) {
        //         if (autoLogonLeaveDuration > AUTO_LOGON_DELAY) {
        //             // TODO ??????????????????
        //         }
        //     }
        //     // ?????????????????????
        //     autoLogonLeaveMoment = 0L
        // }
    }

    /** ?????????????????????????????? */
    internal fun handleBackgroundRemainder(activity: Activity) {
        // if (activity != null) {
        //     ToastUtil.showToast(getStringFromRes(EPApp.getApp(), R.string.lifecycle_in_background))
        // }
    }

    /** ??????????????????????????????????????????????????? */
    internal fun handleBackgroundMoment(activity: Activity) {
        // if (activity != null && activity !is SplashActivity) {
        //     autoLogonLeaveMoment = SystemClock.elapsedRealtime()
        // }
    }

    /**  */
    internal fun handleBackgroundGestureAuth() {
        // if (!activity.javaClass.name.equals(GestureLogonActivity::class.java.getName())) {
        //     val isFpEnable: Boolean = UserAccountDAO.getInstance()
        //             .isFingerprintEnable()
        //     if (GestureSqliteOpenHelper.getInstance()
        //                     .isGestureBeenActivated() || isFpEnable) {
        //         if (ConfigEPA.IS_GESTURE_OPEND) {
        //             userLeaveMoment = SystemClock.elapsedRealtime()
        //             isGestureTimerOpened = true
        //         }
        //     }
        // }
    }


    /** ****************************** Interface ****************************** */

    /**  */
    interface OnAppStatusChangedListener {
        fun onForeground()
        fun onBackground()
    }

    /**  */
    interface OnActivityDestroyedListener {
        fun onActivityDestroyed(activity: Activity?)
    }
}
