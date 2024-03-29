package com.githubyss.common.base.app.page.lifecycle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect_view_model.BaseReflectBindingViewModelToolbarFragment
import com.githubyss.common.base.app.z_copy.startActivityExt
import com.githubyss.common.base.databinding.CombaseFragmentLifecycleBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * LifecycleFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/11 14:51:56
 */
class LifecycleFragment : BaseReflectBindingViewModelToolbarFragment<CombaseFragmentLifecycleBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = LifecycleFragment::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    // private val lifecycleVm by lazy { LifecycleSingletonViewModel }
    private val lifecycleVm by lazy { (activity as LifecycleActivity).lifecycleVm }

    private var fragmentName = this::class.java.simpleName

    /**  */
    private val onClickPresenter by lazy { OnClickPresenter() }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_lifecycle_title)
    }

    /**  */
    override fun bindXmlData() {
        binding.lifecycleVm = lifecycleVm
        binding.onClickPresenter = onClickPresenter
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context)
     *
     * @param context
     * @return
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val message = "$fragmentName > onAttach"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?)
     *
     * @param savedInstanceState
     * @return
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = "$fragmentName > onCreate"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 Nothing
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val message = "$fragmentName > onCreateView"
        lifecycleVm.refreshLifecycleLog(message)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?)
     *
     * @param view
     * @param savedInstanceState
     * @return
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = "$fragmentName > onViewCreated"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentActivityCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?)
     *
     * @param savedInstanceState
     * @return
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val message = "$fragmentName > onActivityCreated"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentStarted(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onStart() {
        super.onStart()
        val message = "$fragmentName > onStart"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentResumed(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onResume() {
        super.onResume()
        val message = "$fragmentName > onResume"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentPaused(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onPause() {
        super.onPause()
        val message = "$fragmentName > onPause"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentStopped(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onStop() {
        super.onStop()
        val message = "$fragmentName > onStop"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentSaveInstanceState(fm: FragmentManager, f: Fragment, outState: Bundle)
     *
     * @param outState
     * @return
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val message = "$fragmentName > onSaveInstanceState"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentViewDestroyed(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onDestroyView() {
        super.onDestroyView()
        val message = "$fragmentName > onDestroyView"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentDestroyed(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onDestroy() {
        super.onDestroy()
        val message = "$fragmentName > onDestroy"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 FragmentLifecycleCallbacks 的 onFragmentDetached(fm: FragmentManager, f: Fragment)
     *
     * @param
     * @return
     */
    override fun onDetach() {
        super.onDetach()
        val message = "$fragmentName > onDetach"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 当一个子 Fragment attach 到当前 Fragment 时
     *
     * @param childFragment
     * @return
     */
    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        val message = "$fragmentName > onAttachFragment"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**  */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        val message = "$fragmentName > onHiddenChanged, hidden:${hidden}"
        lifecycleVm.refreshLifecycleLog(message)
    }


    /** ****************************** Functions ****************************** */


    /** ****************************** Class ****************************** */

    /**  */
    inner class OnClickPresenter {
        fun onStartActivity1(v: View) {
            startActivityExt(activity, LifecycleNextActivity::class.java)
        }

        fun onStartActivity2(v: View) {
            startActivityExt(activity, LifecycleNextActivity::class.java)
        }

        fun onAddFragment(v: View) {
            switchFragment(LifecycleNextFragment(), this@LifecycleFragment, LifecycleNextFragment.TAG, R.id.layout_base_toolbar_fragment_container, true)
        }

        fun onReplaceFragment(v: View) {
            switchFragment(LifecycleNextFragment(), this@LifecycleFragment, LifecycleNextFragment.TAG, R.id.layout_base_toolbar_fragment_container, true)
        }

        fun onClearLog(v: View) {
            lifecycleVm.clearLifecycleLog()
        }
    }
}
