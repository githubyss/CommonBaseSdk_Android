package com.githubyss.common.base.activity_fragment.binding_inline

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_inline_root.RootInlineBindingActivity
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding


/**
 * BaseInlineBindingToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/02 16:45:23
 */
abstract class BaseInlineBindingToolbarActivity<B : ViewDataBinding> : RootInlineBindingActivity<B>() {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Make sure that you can use Toolbar as simple as ActionBar. */
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> setSupportActionBar((binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase)
        }
    }

    /**  */
    override fun onResume() {
        super.onResume()
        setToolbarTitle()
    }


    /** ****************************** Abstract ****************************** */

    /**  */
    abstract fun setToolbarTitle()


    /** ****************************** Functions ****************************** */

    /** Setup Toolbar text by ResId. */
    protected fun setToolbarTitle(titleResId: Int) {
        // toolbarBase.text = getStringFromRes(this@BaseInlineBindingToolbarActivity, titleResId)
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setTitle(titleResId)
        }
    }

    /** Setup Toolbar text by String. */
    protected fun setToolbarTitle(titleString: String) {
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.title = titleString
        }
    }

    /** Setup Toolbar navigation icon by ResId. */
    protected fun setToolbarNavigationIcon(iconResId: Int) {
        // toolbarBase.navigationIcon = getDrawableFromRes(this@BaseInlineBindingToolbarActivity, iconResId)
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setNavigationIcon(iconResId)
        }
    }

    /** Setup Toolbar navigation icon by Drawable. */
    protected fun setToolbarNavigationIcon(iconDrawable: Drawable) {
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.navigationIcon = iconDrawable
        }
    }

    /** Setup Toolbar navigation click listener. */
    protected fun setToolbarNavigationOnClickListener(onBaseToolbarNavigationClickListener: OnBaseToolbarNavigationClickListener) {
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setNavigationOnClickListener { v ->
                onBaseToolbarNavigationClickListener.onClick(v)
            }
        }
    }

    /** Setup Toolbar menu item click listener. */
    protected fun setToolbarMenuItemOnClickListener(onBaseToolbarMenuItemClickListener: OnBaseToolbarMenuItemClickListener) {
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setOnMenuItemClickListener { item ->
                onBaseToolbarMenuItemClickListener.onClick(item)
            }
        }
    }

    /** Get the menu in Toolbar. */
    protected fun getMenu(): Menu? {
        return when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.menu
            else -> null
        }
    }

    /**  */
    protected fun setToolbarOnLongClickListener(onBaseToolbarLongClickListener: OnBaseToolbarLongClickListener) {
        when (binding) {
            is CombaseActivityBaseToolbarBinding -> (binding as CombaseActivityBaseToolbarBinding).layoutToolbar.toolbarBase.setOnLongClickListener { v ->
                onBaseToolbarLongClickListener.onLongClick(v)
            }
        }
    }


    /** ****************************** Interface ****************************** */

    /** Toolbar navigation click listener in BaseInlineBindingToolbarActivity. */
    interface OnBaseToolbarNavigationClickListener {
        fun onClick(v: View)
    }

    /** Toolbar menu item click listener in BaseInlineBindingToolbarActivity. */
    interface OnBaseToolbarMenuItemClickListener {
        fun onClick(item: MenuItem): Boolean
    }

    /**  */
    interface OnBaseToolbarLongClickListener {
        fun onLongClick(v: View): Boolean
    }
}