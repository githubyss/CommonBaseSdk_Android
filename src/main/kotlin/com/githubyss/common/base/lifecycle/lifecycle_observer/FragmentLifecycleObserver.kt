package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.githubyss.common.base.z_copy.logV


/**
 * FragmentLifecycleObserver
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/11 20:24:01
 */
open class FragmentLifecycleObserver private constructor() : LifecycleObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { FragmentLifecycleObserver::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = FragmentLifecycleObserver()
    }


    /** ****************************** Functions ****************************** */

    /**
     * 对应 Fragment 的 onCreate(savedInstanceState: Bundle?)
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
     * 对应 Fragment 的 onStart()
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
     * 对应 Fragment 的 onResume()
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
     * 对应 Fragment 的 onPause()
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
     * 对应 Fragment 的 onStop()
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
     * 对应 Fragment 的 onDestroy()
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
