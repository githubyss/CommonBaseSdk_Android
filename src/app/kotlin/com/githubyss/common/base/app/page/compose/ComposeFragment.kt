package com.githubyss.common.base.app.page.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeFragment
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.z_copy.logD
import com.githubyss.common.res.common.dimen.SpaceNormal


/**
 * ComposeFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/22 15:26:25
 */
class ComposeFragment : BaseComposeFragment() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG by lazy { ComposeFragment::class.java.simpleName ?: "ComposeFragment" }
    }


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            verticalArrangement = Arrangement.Center,
            paddingVertical = Dp.SpaceNormal,
        ) {
            val title = getStringFromRes(R.string.combase_compose)
            logD(TAG, title)
            InfoDisplay(title = title)
        }
    }
}