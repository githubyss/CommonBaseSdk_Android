package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


/**
 * ActivityLifecycleObserverEvent
 *
 * LifecycleEventObserver 本身就是 LifecycleObserver 的派生，使用时直接 addObserver 到 LivecycleOwner 的 Lifecycle 即可。
 *
 * 需要在 onStateChanged 中写 switch / case 自己分发事件。相对于习惯重写 Activity 或者 Fragment 的 onCreate、onResume 等方法，稍显啰嗦。
 * 因此 Lifecycle 给我们准备了 @OnLifecycleEvent 注解。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 18:20:04
 */
open class ActivityLifecycleObserverEvent private constructor() : LifecycleEventObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG = ActivityLifecycleObserverEvent::class.java.simpleName
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = ActivityLifecycleObserverEvent()
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
