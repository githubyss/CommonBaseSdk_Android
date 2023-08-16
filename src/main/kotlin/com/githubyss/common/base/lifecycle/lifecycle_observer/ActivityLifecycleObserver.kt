package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.githubyss.common.base.z_copy.logV


/**
 * ActivityLifecycleObserver
 *
 * 使用方法很简单，继承 LifecycleObserver 接口，然后在成员方法上添加注解即可。
 *
 * 添加注册后，当 LifecycleOwner 的 Event 分发时，会自动回调注解匹配的成员方法，由于省去了手动 switch / case 的过程，深受开发者喜欢。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 17:21:39
 */
open class ActivityLifecycleObserver private constructor() : LifecycleObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { ActivityLifecycleObserver::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = ActivityLifecycleObserver()
    }


    /** ****************************** Functions ****************************** */

    /**
     * 对应 Activity 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        val message = "ON_CREATE"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onStart()
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        val message = "ON_START"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onResume()
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        val message = "ON_RESUME"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onPause()
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        val message = "ON_PAUSE"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onStop()
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        val message = "ON_STOP"
        logV(TAG, message)
    }

    /**
     * 对应 Activity 的 onDestroy()
     *
     * @param
     * @return
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        val message = "ON_DESTROY"
        logV(TAG, message)
    }
}
