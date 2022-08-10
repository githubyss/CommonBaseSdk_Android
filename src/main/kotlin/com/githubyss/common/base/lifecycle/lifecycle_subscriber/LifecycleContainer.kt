package com.githubyss.common.base.lifecycle.lifecycle_subscriber


/**
 * LifecycleContainer
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 10:20:52
 */
object LifecycleContainer {
    /** The activity lifecycle callbacks impl. */
    var activityLifecycle: ActivityLifecycleSubscriber = ActivityLifecycleSubscriber.INSTANCE

    /** The fragment lifecycle callbacks impl. */
    var fragmentLifecycle: FragmentLifecycleSubscriber = FragmentLifecycleSubscriber.INSTANCE
}
