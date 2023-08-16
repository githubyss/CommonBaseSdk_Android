package com.githubyss.common.base.z_copy

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * Switch fragment.
 *
 * @param
 * @return
 */
internal fun FragmentActivity.switchFragment(fragment: Fragment, fragmentTag: String? = null, @IdRes containerId: Int, addToBackStack: Boolean = true, allowingStateLoss: Boolean = true) {
    switchFragmentByAddHideShow(fragment, null, fragmentTag, supportFragmentManager, containerId, intent.extras, addToBackStack, allowingStateLoss)
}

/**
 * Switch fragment.
 *
 * @param
 * @return
 */
internal fun Fragment.switchFragment(fragment: Fragment, fragmentTag: String? = null, currentFragment: Any?, @IdRes containerId: Int, addToBackStack: Boolean = true, allowingStateLoss: Boolean = true) {
    switchFragmentByAddHideShow(fragment, currentFragment, fragmentTag, parentFragmentManager, containerId, null, addToBackStack, allowingStateLoss)
}
