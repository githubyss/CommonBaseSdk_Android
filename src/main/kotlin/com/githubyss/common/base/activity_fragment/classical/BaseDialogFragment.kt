package com.githubyss.common.base.activity_fragment.classical

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseActivityFragmentInterface
import com.githubyss.common.base.activity_fragment.interface_default.BaseBroadcastReceiverInterface
import com.githubyss.common.base.activity_fragment.interface_default.BaseLifecycleInterface
import com.githubyss.common.base.lifecycle.registerLifecycleEx
import com.githubyss.common.base.lifecycle.unregisterLifecycleEx
import com.githubyss.common.base.z_copy.logV


/**
 * BaseDialogFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/25 16:32:26
 */
abstract class BaseDialogFragment(@LayoutRes layoutId: Int = 0) : DialogFragment(layoutId), BaseActivityFragmentInterface, BaseLifecycleInterface, BaseBroadcastReceiverInterface {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseDialogFragment::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private var thisClassName = this::class.java.simpleName


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        logV(TAG, "$thisClassName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val message = "$thisClassName > onAttach"
        logV(TAG, message)
    }

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = "$thisClassName > onCreate"
        logV(TAG, message)

        registerLifecycle()
    }

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val message = "$thisClassName > onCreateView"
        logV(TAG, message)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**  */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = "$thisClassName > onViewCreated"
        logV(TAG, message)

        setupUi()
        setupData()
    }

    /**  */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val message = "$thisClassName > onActivityCreated"
        logV(TAG, message)
    }

    /**  */
    override fun onStart() {
        super.onStart()
        val message = "$thisClassName > onStart"
        logV(TAG, message)
    }

    /**  */
    override fun onResume() {
        super.onResume()
        val message = "$thisClassName > onResume"
        logV(TAG, message)

        registerReceiver()
    }

    /**  */
    override fun onPause() {
        super.onPause()
        val message = "$thisClassName > onPause"
        logV(TAG, message)

        unregisterReceiver()
    }

    /**  */
    override fun onStop() {
        super.onStop()
        val message = "$thisClassName > onStop"
        logV(TAG, message)
    }

    /**  */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val message = "$thisClassName > onSaveInstanceState"
        logV(TAG, message)
    }

    /**  */
    override fun onDestroyView() {
        val message = "$thisClassName > onDestroyView"
        logV(TAG, message)

        super.onDestroyView()
    }

    /**  */
    override fun onDestroy() {
        val message = "$thisClassName > onDestroy"
        logV(TAG, message)

        unregisterLifecycle()
        super.onDestroy()
    }

    /**  */
    override fun onDetach() {
        super.onDetach()
        val message = "$thisClassName > onDetach"
        logV(TAG, message)
    }

    /**  */
    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        val message = "$thisClassName > onAttachFragment"
        logV(TAG, message)
    }

    /**  */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        val message = "$thisClassName > onHiddenChanged, hidden:${hidden}"
        logV(TAG, message)
    }

    /**  */
    override fun registerLifecycle() {
        registerLifecycleEx()
    }

    /**  */
    override fun unregisterLifecycle() {
        unregisterLifecycleEx()
    }
}
