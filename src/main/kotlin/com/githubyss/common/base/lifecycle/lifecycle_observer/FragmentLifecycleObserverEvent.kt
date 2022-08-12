package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


/**
 * FragmentLifecycleObserverEvent
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/12 13:59:36
 */
open class FragmentLifecycleObserverEvent private constructor() : LifecycleEventObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG = FragmentLifecycleObserverEvent::class.java.simpleName
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = FragmentLifecycleObserverEvent()
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val message = StringBuilder("${source::class.java.simpleName} > ")
        message.append(when (event) {
                           Lifecycle.Event.ON_CREATE -> "ON_CREATE"
                           Lifecycle.Event.ON_START -> "ON_START"
                           Lifecycle.Event.ON_RESUME -> "ON_RESUME"
                           Lifecycle.Event.ON_PAUSE -> "ON_PAUSE"
                           Lifecycle.Event.ON_STOP -> "ON_STOP"
                           Lifecycle.Event.ON_DESTROY -> "ON_DESTROY"
                           else -> ""
                       })
        println("$TAG $message")
    }
}
