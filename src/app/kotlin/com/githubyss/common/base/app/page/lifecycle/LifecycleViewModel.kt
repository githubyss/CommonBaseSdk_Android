package com.githubyss.mobile.common.kit.app.page.lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * LifecycleViewModel
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/12 15:50:04
 */
class LifecycleViewModel : ViewModel() {

    /**  */
    val lifecycleLog by lazy { MutableLiveData(StringBuilder()) }


    /** ****************************** Functions ****************************** */

    /**  */
    fun refreshLifecycleLog(message: String) {
        lifecycleLog.value = lifecycleLog.value?.append(message)?.appendLine()
    }

    /**  */
    fun clearLifecycleLog() {
        lifecycleLog.value = lifecycleLog.value?.clear()
    }
}
