package com.githubyss.common.base.app.page.binding_inline

import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_inline.BaseInlineBindingFragment
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.databinding.CombaseFragmentViewBindingInlineBinding
import com.githubyss.common.base.ext.inflateBinding


/**
 * InlineFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/07/20 17:44:22
 */
class InlineFragment : BaseInlineBindingFragment<CombaseFragmentViewBindingInlineBinding>(R.layout.combase_fragment_view_binding_inline) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = InlineFragment::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val _binding by inflateBinding<CombaseFragmentViewBindingInlineBinding>()


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding = _binding
        binding.textBindingInline.text = getStringFromRes(R.string.combase_view_binding_inline)
    }
}
