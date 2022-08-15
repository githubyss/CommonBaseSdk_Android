package com.githubyss.common.base.lifecycle

import com.githubyss.common.base.lifecycle.lifecycle_callbacks.ActivityLifecycleCallbacks
import com.githubyss.common.base.lifecycle.lifecycle_callbacks.FragmentLifecycleCallbacks
import com.githubyss.common.base.lifecycle.lifecycle_observer.*


/**
 * LifecycleHolder
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 10:20:52
 */
object LifecycleHolder {
    var activityLifecycle = ActivityLifecycleObserverDefault.INSTANCE
    var fragmentLifecycle = FragmentLifecycleObserverDefault.INSTANCE

    internal var activityLifecycleCallbacks = ActivityLifecycleCallbacks.INSTANCE
    internal var fragmentLifecycleCallbacks = FragmentLifecycleCallbacks.INSTANCE

    internal var activityLifecycleObserver = ActivityLifecycleObserver.INSTANCE
    internal var fragmentLifecycleObserver = FragmentLifecycleObserver.INSTANCE

    internal var activityLifecycleObserverEvent = ActivityLifecycleObserverEvent.INSTANCE
    internal var fragmentLifecycleObserverEvent = FragmentLifecycleObserverEvent.INSTANCE

    internal var activityLifecycleObserverDefault = ActivityLifecycleObserverDefault.INSTANCE
    internal var fragmentLifecycleObserverDefault = FragmentLifecycleObserverDefault.INSTANCE
}
