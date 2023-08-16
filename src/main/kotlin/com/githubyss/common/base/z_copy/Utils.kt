package com.githubyss.common.base.z_copy

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.lang.reflect.InvocationTargetException


/**
 * Utils
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/15 20:42:27
 */

/** ****************************** Properties ****************************** */

/**  */
private const val TAG: String = "Utils"


/** ****************************** Functions ****************************** */

/**  */
internal fun logV(tag: String = "", msg: String = "") {
    Log.v(tag, msg)
}

/**  */
internal fun logD(tag: String = "", msg: String = "") {
    Log.d(tag, msg)
}

/**  */
internal fun logI(tag: String = "", msg: String = "") {
    Log.i(tag, msg)
}

/**  */
internal fun logW(tag: String = "", msg: String = "") {
    Log.w(tag, msg)
}

/**  */
internal fun logE(tag: String = "", msg: String = "", t: Throwable) {
    Log.e(tag, msg, t)
}

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
        logE(TAG, e::class.java.simpleName, e)
    }
    catch (e: IllegalAccessException) {
        logE(TAG, e::class.java.simpleName, e)
    }
    catch (e: InvocationTargetException) {
        logE(TAG, e::class.java.simpleName, e)
    }
    catch (e: ClassNotFoundException) {
        logE(TAG, e::class.java.simpleName, e)
    }
    throw NullPointerException("u should init first")
}

/**  */
internal fun switchFragmentByAddHideShow(fragment: Fragment?, fragmentTag: String?, currentFragment: Any?, fragmentManager: FragmentManager?, @IdRes containerId: Int, addToBackStack: Boolean = true, bundle: Bundle? = null) {
    fragment ?: return
    fragmentManager ?: return

    val currentFragment: Fragment? = when (currentFragment) {
        is Fragment -> {
            currentFragment
        }
        is String -> {
            fragmentManager.findFragmentByTag(currentFragment)
        }
        else -> null
    }

    fragment.arguments = bundle
    val fragmentTransaction = fragmentManager.beginTransaction()
    if (currentFragment == null) {
        fragmentTransaction.add(containerId, fragment, fragmentTag)
    }
    else if (currentFragment != fragment) {
        fragmentTransaction.hide(currentFragment)
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        }
        else {
            fragmentTransaction.add(containerId, fragment, fragmentTag)
        }
    }
    if (addToBackStack) fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commitAllowingStateLoss()
}
