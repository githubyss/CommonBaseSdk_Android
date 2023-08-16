package com.githubyss.common.base.app.page.binding_inline

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseBinding
import com.githubyss.common.base.ext.inflateBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * InlineActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/07/20 17:42:44
 */
class InlineActivity : BaseInlineBindingActivity<CombaseActivityBaseBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG: String = InlineActivity::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val _binding by inflateBinding<CombaseActivityBaseBinding>()


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding = _binding
        switchFragment(InlineFragment(), InlineFragment.TAG, R.id.layout_base_fragment_container, false)
    }
}
