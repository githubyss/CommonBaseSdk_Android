package com.githubyss.common.base.lifecycle.lifecycle_callbacks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.githubyss.common.base.z_copy.logV


/**
 * FragmentLifecycleCallbacks
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/03 10:14:08
 */
open class FragmentLifecycleCallbacks private constructor() : FragmentManager.FragmentLifecycleCallbacks() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { FragmentLifecycleCallbacks::class.java.simpleName }
        val INSTANCE = Holder.INSTANCE
    }

    /**  */
    private object Holder {
        val INSTANCE = FragmentLifecycleCallbacks()
    }


    /** ****************************** Override ****************************** */

    /**
     * 对应 Fragment 的 onAttach(context: Context)
     *
     * @param fm
     * @param f
     * @param context
     * @return
     */
    override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
        val message = "${f::class.java.simpleName} > onFragmentAttached"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onCreate(savedInstanceState: Bundle?)
     *
     * @param fm
     * @param f
     * @param savedInstanceState
     * @return
     */
    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
        val message = "${f::class.java.simpleName} > onFragmentCreated"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onViewCreated(view: View, savedInstanceState: Bundle?)
     *
     * @param fm
     * @param f
     * @param v
     * @param savedInstanceState
     * @return
     */
    override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
        val message = "${f::class.java.simpleName} > onFragmentViewCreated"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onActivityCreated(savedInstanceState: Bundle?)
     *
     * @param fm
     * @param f
     * @param savedInstanceState
     * @return
     */
    override fun onFragmentActivityCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
        val message = "${f::class.java.simpleName} > onFragmentActivityCreated"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onStart()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentStarted"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onResume()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentResumed"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onPause()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentPaused"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onStop()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentStopped"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onSaveInstanceState(outState: Bundle)
     *
     * @param fm
     * @param f
     * @param outState
     * @return
     */
    override fun onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle) {
        val message = "${f::class.java.simpleName} > onFragmentSaveInstanceState"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onDestroyView()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentViewDestroyed"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onDestroy()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentDestroyed"
        logV(TAG, message)
    }

    /**
     * 对应 Fragment 的 onDetach()
     *
     * @param fm
     * @param f
     * @return
     */
    override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
        val message = "${f::class.java.simpleName} > onFragmentDetached"
        logV(TAG, message)
    }
}
