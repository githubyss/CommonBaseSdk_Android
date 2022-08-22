package com.githubyss.common.base.app.page.compose.fragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarFragment
import com.githubyss.common.base.app.compose_ui.InfoDisplay
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.mobile.common.res.common.dimen.SpaceNormal


/**
 * ComposeToolbarFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/24 16:04:32
 */
class ComposeToolbarFragment : BaseComposeToolbarFragment() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = ComposeToolbarFragment::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Toolbar() {
        TopNavigationBar(getStringFromRes(R.string.combase_compose_toolbar_title)) { activity?.onBackPressed() }
    }

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            verticalArrangement = Arrangement.Center,
            paddingVertical = Dp.SpaceNormal,
        ) {
            InfoDisplay(title = getStringFromRes(R.string.combase_compose_toolbar))
        }
    }
}
