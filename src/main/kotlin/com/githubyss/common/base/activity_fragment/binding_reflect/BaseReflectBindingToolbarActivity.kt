package com.githubyss.common.base.activity_fragment.binding_reflect

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.binding_reflect_root.RootReflectBindingActivity
import com.githubyss.common.base.activity_fragment.interface_default.BaseToolbarInterface
import com.githubyss.common.base.databinding.CombaseActivityBaseToolbarBinding


/**
 * BaseReflectBindingToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/03/09 14:35:21
 */
abstract class BaseReflectBindingToolbarActivity<B : ViewDataBinding> : RootReflectBindingActivity<B>(), BaseToolbarInterface {

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


    /** ****************************** Functions ****************************** */

    /** Setup Toolbar text by ResId. */
    protected fun setToolbarTitle(titleResId: Int) {
        // toolbarBase.text = getStringFromRes(this@BaseReflectBindingToolbarActivity, titleResId)
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
        // toolbarBase.navigationIcon = getDrawableFromRes(this@BaseReflectBindingToolbarActivity, iconResId)
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

    /** Toolbar navigation click listener in BaseReflectBindingToolbarActivity. */
    interface OnBaseToolbarNavigationClickListener {
        fun onClick(v: View)
    }

    /** Toolbar menu item click listener in BaseReflectBindingToolbarActivity. */
    interface OnBaseToolbarMenuItemClickListener {
        fun onClick(item: MenuItem): Boolean
    }

    /**  */
    interface OnBaseToolbarLongClickListener {
        fun onLongClick(v: View): Boolean
    }
}
