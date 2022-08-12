package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


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
        private val TAG = ActivityLifecycleObserverDefault::class.java.simpleName
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = ActivityLifecycleObserverDefault()
    }


    /** ****************************** Functions ****************************** */

    /**
     * 对应 Activity 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param
     * @return
     */
    override fun onCreate(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onCreate"
        println("$TAG $message")
    }

    /**
     * 对应 Activity 的 onStart()
     *
     * @param
     * @return
     */
    override fun onStart(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStart"
        println("$TAG $message")
    }

    /**
     * 对应 Activity 的 onResume()
     *
     * @param
     * @return
     */
    override fun onResume(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onResume"
        println("$TAG $message")
    }

    /**
     * 对应 Activity 的 onPause()
     *
     * @param
     * @return
     */
    override fun onPause(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onPause"
        println("$TAG $message")
    }

    /**
     * 对应 Activity 的 onStop()
     *
     * @param
     * @return
     */
    override fun onStop(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStop"
        println("$TAG $message")
    }

    /**
     * 对应 Activity 的 onDestroy()
     *
     * @param
     * @return
     */
    override fun onDestroy(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onDestroy"
        println("$TAG $message")
    }
}
