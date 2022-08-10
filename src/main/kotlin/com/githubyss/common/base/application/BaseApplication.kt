package com.githubyss.common.base.application

import android.app.Application
import android.content.Context
import com.githubyss.common.base.lifecycle.lifecycle_subscriber.LifecycleContainer
import kotlin.properties.Delegates


/**
 * BaseApplication
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 10:29:14
 */
abstract class BaseApplication : Application() {

    /** ****************************** Companion ****************************** */

    /**  */
    companion object {
        private val TAG: String = BaseApplication::class.java.simpleName

        var instance: BaseApplication by Delegates.notNull()
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate() {
        super.onCreate()
        instance = this

        initComkit()
        initComnet()
        initLog()
        initARouter()
        registerLifecycle()
    }

    /**  */
    override fun onTerminate() {
        unregisterLifecycle()
        super.onTerminate()
    }

    /**  */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        initTrace()
    }


    /** ****************************** Open ****************************** */

    /**  */
    open fun initComkit() {}

    /**  */
    open fun initComnet() {}

    /**  */
    open fun initLog() {}

    /**  */
    open fun initARouter() {}

    /**  */
    open fun initTrace() {}


    /** ****************************** Functions ****************************** */

    /**  */
    private fun registerLifecycle() {
        registerActivityLifecycleCallbacks(LifecycleContainer.activityLifecycle)
    }

    /**  */
    private fun unregisterLifecycle() {
        unregisterActivityLifecycleCallbacks(LifecycleContainer.activityLifecycle)
        LifecycleContainer.activityLifecycle.activityList.clear()
    }
}
