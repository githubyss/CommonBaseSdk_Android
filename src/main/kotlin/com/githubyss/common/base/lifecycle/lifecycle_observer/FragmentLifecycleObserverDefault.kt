package com.githubyss.common.base.lifecycle.lifecycle_observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.githubyss.common.base.z_copy.logV


/**
 * FragmentLifecycleObserverDefault
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/12 13:59:14
 */
open class FragmentLifecycleObserverDefault private constructor() : DefaultLifecycleObserver {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { FragmentLifecycleObserverDefault::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = FragmentLifecycleObserverDefault()
    }


    /** ****************************** Functions ****************************** */

    /**
     * 对应 Fragment 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param
     * @return
     */
    override fun onCreate(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onCreate"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onStart()
     *
     * @param
     * @return
     */
    override fun onStart(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStart"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onResume()
     *
     * @param
     * @return
     */
    override fun onResume(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onResume"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onPause()
     *
     * @param
     * @return
     */
    override fun onPause(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onPause"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onStop()
     *
     * @param
     * @return
     */
    override fun onStop(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onStop"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onDestroy()
     *
     * @param
     * @return
     */
    override fun onDestroy(owner: LifecycleOwner) {
        val message = "${owner::class.java.simpleName} > onDestroy"
        logV(TAG, message)
    }
}
