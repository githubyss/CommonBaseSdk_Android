package com.githubyss.common.base.app.page.binding_reflect

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingToolbarFragment
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.databinding.CombaseFragmentViewBindingReflectBinding


/**
 * ReflectToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/03 19:46:28
 */
class ReflectToolbarFragment : BaseReflectBindingToolbarFragment<CombaseFragmentViewBindingReflectBinding>() {
    
    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = ReflectToolbarFragment::class.java.simpleName
    }
    
    
    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding.textBindingReflect?.text = getStringFromRes(R.string.combase_view_binding_reflect_toolbar)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_view_binding_reflect_toolbar_title)
    }
}
