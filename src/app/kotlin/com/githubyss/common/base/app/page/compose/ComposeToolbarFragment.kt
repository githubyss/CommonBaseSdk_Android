package com.githubyss.common.base.app.page.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarFragment
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.z_copy.logD
import com.githubyss.common.res.common.dimen.SpaceNormal


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
        val TAG by lazy { ComposeToolbarFragment::class.java.simpleName ?: "ComposeToolbarFragment" }
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
            val title = getStringFromRes(R.string.combase_compose_toolbar)
            logD(TAG, title)
            InfoDisplay(title = title)
        }
    }
}
