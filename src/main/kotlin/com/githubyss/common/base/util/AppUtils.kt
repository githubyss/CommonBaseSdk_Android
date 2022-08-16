package com.githubyss.common.base.util

import android.annotation.SuppressLint
import android.app.Application
import java.lang.reflect.InvocationTargetException


/**
 * AppUtils
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/15 20:42:27
 */

/** ****************************** Properties ****************************** */

/**  */
private const val TAG: String = "AppUtils"


/** ****************************** Functions ****************************** */

/**  */
internal fun getApplicationByReflect(): Application {
    try {
        @SuppressLint("PrivateApi")
        val activityThread = Class.forName("android.app.ActivityThread")
        val thread = activityThread.getMethod("currentActivityThread")
            .invoke(null)
        val app = activityThread.getMethod("getApplication")
            .invoke(thread) ?: throw NullPointerException("u should init first")
        return app as Application
    }
    catch (e: NoSuchMethodException) {
        println("$TAG $e")
    }
    catch (e: IllegalAccessException) {
        println("$TAG $e")
    }
    catch (e: InvocationTargetException) {
        println("$TAG $e")
    }
    catch (e: ClassNotFoundException) {
        println("$TAG $e")
    }
    throw NullPointerException("u should init first")
}
