package com.githubyss.common.base.app.page.binding_reflect

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect.BaseReflectBindingFragment
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.databinding.CombaseFragmentViewBindingReflectBinding


/**
 * ReflectFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/07/21 11:16:42
 */
class ReflectFragment : BaseReflectBindingFragment<CombaseFragmentViewBindingReflectBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = ReflectFragment::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding.textBindingReflect?.text = getStringFromRes(R.string.combase_view_binding_reflect)
    }
}
