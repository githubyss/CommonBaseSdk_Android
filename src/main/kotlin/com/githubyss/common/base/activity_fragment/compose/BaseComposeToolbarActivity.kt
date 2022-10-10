package com.githubyss.common.base.activity_fragment.compose

import androidx.compose.runtime.Composable
import com.githubyss.common.base.activity_fragment.compose_root.RootComposeActivity
import com.githubyss.common.base.activity_fragment.interface_default.BaseToolbarComposeInterface


/**
 * BaseComposeToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/24 15:57:42
 */
abstract class BaseComposeToolbarActivity : RootComposeActivity(), BaseToolbarComposeInterface {

    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Page() {
        Toolbar()
        Content()
    }


    // /** ****************************** Functions ****************************** */
    //
    // /** Setup Toolbar text by ResId. */
    // @Composable
    // protected fun Toolbar(titleResId: Int) {
    //     Toolbar(
    //         titleString = getStringFromRes(titleResId),
    //     )
    // }
    //
    // /** Setup Toolbar text by String. */
    // @Composable
    // protected fun Toolbar(titleString: String) {
    //     BaseToolbar(
    //         title = titleString,
    //         onNavigationIconClick = { onBackPressed() },
    //     )
    // }
}