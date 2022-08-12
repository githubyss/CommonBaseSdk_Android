package com.githubyss.common.base.lifecycle

import com.githubyss.common.base.lifecycle.lifecycle_callbacks.ActivityLifecycleCallbacks
import com.githubyss.common.base.lifecycle.lifecycle_callbacks.FragmentLifecycleCallbacks
import com.githubyss.common.base.lifecycle.lifecycle_observer.*


/**
 * LifecycleContainer
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 10:20:52
 */
object LifecycleContainer {
    var activityLifecycleCallbacks = ActivityLifecycleCallbacks.INSTANCE
    var fragmentLifecycleCallbacks = FragmentLifecycleCallbacks.INSTANCE

    var activityLifecycleObserver = ActivityLifecycleObserver.INSTANCE
    var fragmentLifecycleObserver = FragmentLifecycleObserver.INSTANCE

    var activityLifecycleObserverEvent = ActivityLifecycleObserverEvent.INSTANCE
    var fragmentLifecycleObserverEvent = FragmentLifecycleObserverEvent.INSTANCE

    var activityLifecycleObserverDefault = ActivityLifecycleObserverDefault.INSTANCE
    var fragmentLifecycleObserverDefault = FragmentLifecycleObserverDefault.INSTANCE
}
