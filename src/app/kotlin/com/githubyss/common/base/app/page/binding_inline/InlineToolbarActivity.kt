package com.githubyss.common.base.app.page.binding_inline

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingToolbarActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding
import com.githubyss.common.base.ext.inflateBinding
import com.githubyss.common.base.z_copy.switchFragment


/**
 * InlineToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/04 14:55:13
 */
class InlineToolbarActivity : BaseInlineBindingToolbarActivity<CombaseActivityBaseToolbarBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG: String = InlineToolbarActivity::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val _binding by inflateBinding<CombaseActivityBaseToolbarBinding>()


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding = _binding
        switchFragment(InlineToolbarFragment(), InlineToolbarFragment.TAG, R.id.layout_base_toolbar_fragment_container, false)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_view_binding_inline_toolbar_title)
    }
}
