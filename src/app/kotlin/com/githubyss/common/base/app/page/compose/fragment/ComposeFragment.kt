package com.githubyss.common.base.app.page.compose.fragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeFragment
import com.githubyss.common.base.app.compose_ui.InfoDisplay
import com.githubyss.common.base.app.z_copy.comui.PageSidePadding
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.mobile.common.res.common.dimen.SpaceNormal


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
        val TAG: String = ComposeFragment::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            verticalArrangement = Arrangement.Center,
            paddingVertical = Dp.SpaceNormal,
        ) {
            InfoDisplay(title = getStringFromRes(R.string.combase_compose))
        }
    }
}