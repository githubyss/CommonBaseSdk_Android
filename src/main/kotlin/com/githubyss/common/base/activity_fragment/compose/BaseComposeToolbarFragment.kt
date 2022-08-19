package com.githubyss.common.base.activity_fragment.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.githubyss.common.base.activity_fragment.compose_root.RootComposeFragment


/**
 * BaseComposeToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/22 15:54:36
 */
abstract class BaseComposeToolbarFragment : RootComposeFragment() {

    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Page() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Toolbar()
            Content()
        }
    }


    /** ****************************** Abstract ****************************** */

    /**  */
    @Composable
    abstract fun Toolbar()


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
    //         onNavigationIconClick = {activity?.onBackPressed()},
    //     )
    // }
}