package com.githubyss.common.base.app.page.mvi

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingToolbarActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding


/**
 * MviActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/17 17:30:59
 */
class MviActivity : BaseReflectBindingToolbarActivity<CombaseActivityBaseToolbarBinding>() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = MviActivity::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        switchFragment(MviFragment(), MviFragment.TAG, FRAGMENT_BASE_TOOLBAR_CONTAINER_ID, false)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_mvi_title)
    }
}
