package com.githubyss.common.base.app.page.lifecycle

import android.os.Bundle
import androidx.activity.viewModels
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect_view_model.BaseReflectBindingViewModelToolbarActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * LifecycleActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/11 15:19:51
 */
class LifecycleActivity : BaseReflectBindingViewModelToolbarActivity<CombaseActivityBaseToolbarBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG = LifecycleActivity::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    // private val lifecycleVm by lazy { LifecycleSingletonViewModel }
    val lifecycleVm by viewModels<LifecycleViewModel>()

    /**  */
    private var activityName = this::class.java.simpleName


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        switchFragment(LifecycleFragment(), LifecycleFragment.TAG, R.id.layout_base_toolbar_fragment_container, false)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_lifecycle_title)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityCreated(activity: Activity, savedInstanceState: Bundle?)
     *
     * @param savedInstanceState
     * @return
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = "$activityName > onCreate"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityStarted(activity: Activity)
     *
     * @param
     * @return
     */
    override fun onStart() {
        super.onStart()
        val message = "$activityName > onStart"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 Nothing
     *
     * @param
     * @return
     */
    override fun onRestart() {
        super.onRestart()
        val message = "$activityName > onRestart"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityResumed(activity: Activity)
     *
     * @param
     * @return
     */
    override fun onResume() {
        super.onResume()
        val message = "$activityName > onResume"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityPaused(activity: Activity)
     *
     * @param
     * @return
     */
    override fun onPause() {
        super.onPause()
        val message = "$activityName > onPause"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityStopped(activity: Activity)
     *
     * @param
     * @return
     */
    override fun onStop() {
        super.onStop()
        val message = "$activityName > onStop"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivitySaveInstanceState(activity: Activity, outState: Bundle)
     *
     * @param outState
     * @return
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val message = "$activityName > onSaveInstanceState"
        lifecycleVm.refreshLifecycleLog(message)
    }

    /**
     * 对应 ActivityLifecycleCallbacks 的 onActivityDestroyed(activity: Activity)
     *
     * @param
     * @return
     */
    override fun onDestroy() {
        super.onDestroy()
        val message = "$activityName > onDestroy"
        lifecycleVm.refreshLifecycleLog(message)
    }
}
