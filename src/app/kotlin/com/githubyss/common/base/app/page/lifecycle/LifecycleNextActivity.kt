package com.githubyss.common.base.app.page.lifecycle

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingToolbarActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * LifecycleNextActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/15 10:44:18
 */
class LifecycleNextActivity : BaseReflectBindingToolbarActivity<CombaseActivityBaseToolbarBinding>() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = LifecycleNextActivity::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        switchFragment(LifecycleNextFragment(), LifecycleNextFragment.TAG, R.id.layout_base_toolbar_fragment_container, false)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_lifecycle_title)
    }
}
