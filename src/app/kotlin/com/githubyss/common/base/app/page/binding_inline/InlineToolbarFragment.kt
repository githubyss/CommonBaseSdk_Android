package com.githubyss.common.base.app.page.binding_inline

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingToolbarFragment
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.databinding.CombaseFragmentViewBindingInlineBinding
import com.githubyss.common.base.ext.inflateBinding


/**
 * InlineToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/04 14:52:55
 */
class InlineToolbarFragment : BaseInlineBindingToolbarFragment<CombaseFragmentViewBindingInlineBinding>(R.layout.combase_fragment_view_binding_inline) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = InlineToolbarFragment::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val _binding by inflateBinding<CombaseFragmentViewBindingInlineBinding>()


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding = _binding
        binding.textBindingInline.text = getStringFromRes(R.string.combase_view_binding_inline_toolbar)
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_view_binding_inline_toolbar_title)
    }
}
