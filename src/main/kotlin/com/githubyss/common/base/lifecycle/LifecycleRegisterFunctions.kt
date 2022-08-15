package com.githubyss.common.base.lifecycle

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


/**  */
fun Application.registerLifecycle() {
    // registerActivityLifecycleCallbacks(LifecycleHolder.activityLifecycleCallbacks)
}

/**  */
fun Application.unregisterLifecycle() {
    LifecycleHolder.activityLifecycle.activityHolder.activityList.clear()

    // unregisterActivityLifecycleCallbacks(LifecycleHolder.activityLifecycleCallbacks)
    // LifecycleHolder.activityLifecycleCallbacks.activityHolder.activityList.clear()
    // LifecycleHolder.activityLifecycleObserverDefault.activityHolder.activityList.clear()
}

/**  */
fun AppCompatActivity.registerLifecycle() {
    lifecycle.addObserver(LifecycleHolder.activityLifecycle)

    // supportFragmentManager.registerFragmentLifecycleCallbacks(LifecycleHolder.fragmentLifecycleCallbacks, true)
    // lifecycle.addObserver(LifecycleHolder.activityLifecycleObserver)
    // lifecycle.addObserver(LifecycleHolder.activityLifecycleObserverEvent)
    // lifecycle.addObserver(LifecycleHolder.activityLifecycleObserverDefault)
}

/**  */
fun AppCompatActivity.unregisterLifecycle() {
    lifecycle.removeObserver(LifecycleHolder.activityLifecycle)

    // supportFragmentManager.unregisterFragmentLifecycleCallbacks(LifecycleHolder.fragmentLifecycleCallbacks)
    // lifecycle.removeObserver(LifecycleHolder.activityLifecycleObserver)
    // lifecycle.removeObserver(LifecycleHolder.activityLifecycleObserverEvent)
    // lifecycle.removeObserver(LifecycleHolder.activityLifecycleObserverDefault)
}

/**  */
fun Fragment.registerLifecycle() {
    lifecycle.addObserver(LifecycleHolder.fragmentLifecycle)

    // lifecycle.addObserver(LifecycleHolder.fragmentLifecycleObserver)
    // lifecycle.addObserver(LifecycleHolder.fragmentLifecycleObserverEvent)
    // lifecycle.addObserver(LifecycleHolder.fragmentLifecycleObserverDefault)
}

/**  */
fun Fragment.unregisterLifecycle() {
    lifecycle.removeObserver(LifecycleHolder.fragmentLifecycle)

    // lifecycle.removeObserver(LifecycleHolder.fragmentLifecycleObserver)
    // lifecycle.removeObserver(LifecycleHolder.fragmentLifecycleObserverEvent)
    // lifecycle.removeObserver(LifecycleHolder.fragmentLifecycleObserverDefault)
}
