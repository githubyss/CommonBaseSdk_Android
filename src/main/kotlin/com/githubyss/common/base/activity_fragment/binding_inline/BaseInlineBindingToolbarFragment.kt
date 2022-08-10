package com.githubyss.common.base.activity_fragment.binding_inline

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline_root.RootInlineBindingFragment
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding


/**
 * BaseInlineBindingToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/02 16:52:19
 */
abstract class BaseInlineBindingToolbarFragment<B : ViewDataBinding>(@LayoutRes layoutId: Int) : RootInlineBindingFragment<B>(layoutId) {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onResume() {
        super.onResume()
        setToolbarTitle()
    }

    /**  */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            setToolbarTitle()
        }
    }


    /** ****************************** Abstract ****************************** */

    /**  */
    abstract fun setToolbarTitle()


    /** ****************************** Functions ****************************** */

    /** Setup Toolbar text by ResId. */
    protected fun setToolbarTitle(titleResId: Int) {
        when {
            activity is BaseInlineBindingToolbarActivity<*> && (activity as BaseInlineBindingToolbarActivity<*>).binding is CombaseActivityBaseToolbarBinding -> {
                ((activity as BaseInlineBindingToolbarActivity<*>).binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setTitle(titleResId)
            }
        }
    }

    /** Setup Toolbar text by String. */
    protected fun setToolbarTitle(titleString: String) {
        when {
            activity is BaseInlineBindingToolbarActivity<*> && (activity as BaseInlineBindingToolbarActivity<*>).binding is CombaseActivityBaseToolbarBinding -> {
                ((activity as BaseInlineBindingToolbarActivity<*>).binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.title = titleString
            }
        }
    }
}
