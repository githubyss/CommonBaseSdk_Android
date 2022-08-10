package com.githubyss.common.base.activity_fragment.binding_inline_root

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.classical.BaseFragment


/**
 * RootInlineBindingFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/22 13:59:23
 */
abstract class RootInlineBindingFragment<B : ViewDataBinding>(@LayoutRes layoutId: Int) : BaseFragment(layoutId) {
    lateinit var binding: B
}
