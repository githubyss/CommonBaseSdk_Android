package com.githubyss.common.base.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * FragmentUtils
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/15 20:45:02
 */

/** ****************************** Properties ****************************** */

/**  */
private const val TAG: String = "FragmentUtils"


/** ****************************** Functions ****************************** */

/**  */
internal fun switchFragmentByAddHideShow(fragment: Fragment?, fragmentTag: String?, currentFragment: Any?, fragmentManager: FragmentManager?, @IdRes containerId: Int, addToBackStack: Boolean = true, bundle: Bundle? = null) {
    fragment ?: return
    fragmentManager ?: return

    val currentFragment: Fragment? = when (currentFragment) {
        is Fragment -> {
            currentFragment
        }
        is String -> {
            fragmentManager.findFragmentByTag(currentFragment)
        }
        else -> null
    }

    fragment.arguments = bundle
    val fragmentTransaction = fragmentManager.beginTransaction()
    if (currentFragment == null) {
        fragmentTransaction.add(containerId, fragment, fragmentTag)
    }
    else if (currentFragment != fragment) {
        fragmentTransaction.hide(currentFragment)
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
        }
        else {
            fragmentTransaction.add(containerId, fragment, fragmentTag)
        }
    }
    if (addToBackStack) fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commitAllowingStateLoss()
}
