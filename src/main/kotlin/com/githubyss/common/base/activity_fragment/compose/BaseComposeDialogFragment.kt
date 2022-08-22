package com.githubyss.common.base.activity_fragment.compose

import androidx.compose.runtime.Composable
import com.githubyss.common.base.activity_fragment.compose_root.RootComposeFragment


/**
 * BaseComposeDialogFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 10:56:29
 */
abstract class BaseComposeDialogFragment : RootComposeFragment() {

    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Page() {
        Content()
    }
}