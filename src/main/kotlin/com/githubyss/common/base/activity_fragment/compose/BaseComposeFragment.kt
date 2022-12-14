package com.githubyss.common.base.activity_fragment.compose

import androidx.compose.runtime.Composable
import com.githubyss.common.base.activity_fragment.compose_root.RootComposeFragment


/**
 * BaseComposeFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/22 15:54:36
 */
abstract class BaseComposeFragment : RootComposeFragment() {

    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Page() {
        Content()
    }
}