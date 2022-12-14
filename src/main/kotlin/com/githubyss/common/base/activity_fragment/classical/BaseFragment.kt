package com.githubyss.common.base.activity_fragment.classical

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseActivityFragmentInterface
import com.githubyss.common.base.activity_fragment.interface_default.BaseAnimatorInterface
import com.githubyss.common.base.activity_fragment.interface_default.BaseBroadcastReceiverInterface
import com.githubyss.common.base.activity_fragment.interface_default.BaseLifecycleInterface
import com.githubyss.common.base.application.BaseApplicationHolder.init
import com.githubyss.common.base.lifecycle.registerLifecycleEx
import com.githubyss.common.base.lifecycle.unregisterLifecycleEx
import com.githubyss.common.base.z_copy.switchFragmentByAddHideShow


/**
 * BaseFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/02 15:11:59
 */
abstract class BaseFragment(@LayoutRes layoutId: Int = 0) : Fragment(layoutId), BaseActivityFragmentInterface, BaseLifecycleInterface, BaseBroadcastReceiverInterface, BaseAnimatorInterface {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG by lazy { BaseFragment::class.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val fragmentName by lazy { this::class.simpleName }


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        println("$TAG $fragmentName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val message = "$fragmentName > onAttach"
        println("$TAG $message")
    }

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = "$fragmentName > onCreate"
        println("$TAG $message")

        registerLifecycle()
    }

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val message = "$fragmentName > onCreateView"
        println("$TAG $message")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**  */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = "$fragmentName > onViewCreated"
        println("$TAG $message")

        setupUi()
        setupData()
    }

    /**  */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val message = "$fragmentName > onActivityCreated"
        println("$TAG $message")
    }

    /**  */
    override fun onStart() {
        super.onStart()
        val message = "$fragmentName > onStart"
        println("$TAG $message")
    }

    /**  */
    override fun onResume() {
        super.onResume()
        val message = "$fragmentName > onResume"
        println("$TAG $message")

        registerReceiver()
    }

    /**  */
    override fun onPause() {
        super.onPause()
        val message = "$fragmentName > onPause"
        println("$TAG $message")

        unregisterReceiver()
    }

    /**  */
    override fun onStop() {
        super.onStop()
        val message = "$fragmentName > onStop"
        println("$TAG $message")
    }

    /**  */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val message = "$fragmentName > onSaveInstanceState"
        println("$TAG $message")
    }

    /**  */
    override fun onDestroyView() {
        val message = "$fragmentName > onDestroyView"
        println("$TAG $message")

        super.onDestroyView()
    }

    /**  */
    override fun onDestroy() {
        val message = "$fragmentName > onDestroy"
        println("$TAG $message")

        unregisterLifecycle()
        super.onDestroy()
    }

    /**  */
    override fun onDetach() {
        super.onDetach()
        val message = "$fragmentName > onDetach"
        println("$TAG $message")
    }

    /**  */
    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        val message = "$fragmentName > onAttachFragment"
        println("$TAG $message")
    }

    /**  */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        val message = "$fragmentName > onHiddenChanged, hidden:${hidden}"
        println("$TAG $message")
    }

    /**  */
    override fun registerLifecycle() {
        registerLifecycleEx()
    }

    /**  */
    override fun unregisterLifecycle() {
        unregisterLifecycleEx()
    }


    /** ****************************** Functions ****************************** */

    /** Switch fragment within fragments. */
    protected fun switchFragment(fragment: Fragment, fragmentTag: String? = null, currentFragment: Any?, @IdRes containerId: Int, addToBackStack: Boolean = true) {
        switchFragmentByAddHideShow(fragment, fragmentTag, currentFragment, parentFragmentManager, containerId, addToBackStack)
    }
}
