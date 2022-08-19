package com.githubyss.common.base.app.z_copy

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import com.githubyss.common.base.application.BaseApplicationHolder
import java.util.*


/**
 * Utils
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/19 10:02:03
 */

/** ****************************** Properties ****************************** */

/**  */
private const val TAG: String = "Utils"

/**  */
private const val BUFFER_SIZE = 8 * 1024


/** ****************************** Functions ****************************** */

/**  */
fun logD(tag: String = TAG, msg: String = "") {
    Log.d(tag, msg)
}

/**  */
fun logE(tag: String = TAG, msg: String = "", t: Throwable) {
    Log.e(tag, msg, t)
}

/**  */
fun getStringFromRes(resId: Int, vararg resFormat: Any = emptyArray(), context: Context? = BaseApplicationHolder.getApp()): String {
    context ?: return ""

    return try {
        if (resFormat.isEmpty()) getContextResources(context).getString(resId)
        else getContextResources(context).getString(resId, resFormat)
    }
    catch (e: Resources.NotFoundException) {
        logE(TAG, t = e)
        ""
    }
}

fun getContextResources(context: Context? = BaseApplicationHolder.getApp()): Resources {
    context ?: return Resources.getSystem()
    return context.resources
}

fun startActivityExt(context: Any?, clazz: Class<out Activity?>?, extras: Bundle? = null, options: Bundle? = null): Boolean {
    context ?: return false
    clazz ?: return false

    return when (context) {
        is Context -> {
            startActivityExt(context, context.packageName, clazz.name, extras, options)
            true
        }
        is Activity -> {
            startActivityExt(context, context.packageName, clazz.name, extras, options)
            true
        }
        else -> false
    }
}

fun startActivityExt(context: Any?, packageName: String?, cls: String?, extras: Bundle? = null, options: Bundle? = null): Boolean {
    context ?: return false
    packageName ?: return false
    cls ?: return false

    return when (context) {
        is Context, is Activity -> {
            val intent = Intent(Intent.ACTION_VIEW)
            if (extras != null) {
                intent.putExtras(extras)
            }
            intent.component = ComponentName(packageName, cls)
            startActivityExt(context, intent, options)
            true
        }
        else -> false
    }
}

fun startActivityExt(context: Any?, intent: Intent?, options: Bundle? = null): Boolean {
    context ?: return false
    intent ?: return false

    when (context) {
        is Context -> {
            if (!isIntentAvailable(context, intent)) {
                logD(TAG, "intent is unavailable")
                return false
            }
            if (context !is Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) context.startActivity(intent, options)
            else context.startActivity(intent)

            return true
        }
        is Activity -> {
            if (!isIntentAvailable(context, intent)) {
                logD(TAG, "intent is unavailable")
                return false
            }
            if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) context.startActivity(intent, options)
            else context.startActivity(intent)

            return true
        }
        else -> return false
    }
}

private fun isIntentAvailable(context: Context? = BaseApplicationHolder.getApp(), intent: Intent?): Boolean {
    context ?: return false
    intent ?: return false

    return context.packageManager?.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)?.size ?: -1 > 0
}


private var timer: Timer? = null

fun runTaskPeriodicallyWithTimeOffset(timerTask: TimerTask, delay: Long?, period: Long?): Boolean {
    delay ?: return false
    period ?: return false

    initTimer()
    return try {
        timer?.scheduleAtFixedRate(timerTask, delay, period)
        true
    }
    catch (e: Exception) {
        logE(TAG, t = e)
        false
    }
}

fun cancelTimer() {
    timer?.cancel()
    timer?.purge()
    timer = null
}

private fun initTimer() {
    if (timer == null) {
        timer = Timer()
    }
}