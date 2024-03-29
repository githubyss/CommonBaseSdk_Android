package com.githubyss.common.base.app.page.binding_reflect

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingToolbarActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * ReflectToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/03 19:17:26
 */
class ReflectToolbarActivity : BaseReflectBindingToolbarActivity<CombaseActivityBaseToolbarBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG: String = ReflectToolbarActivity::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_view_binding_reflect_toolbar_title)
    }

    /**  */
    override fun setupUi() {
        switchFragment(ReflectToolbarFragment(), ReflectToolbarFragment.TAG, R.id.layout_base_toolbar_fragment_container, false)
    }
}
