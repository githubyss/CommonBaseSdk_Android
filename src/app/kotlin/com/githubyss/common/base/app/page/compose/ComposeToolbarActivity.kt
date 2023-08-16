package com.githubyss.common.base.app.page.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarActivity
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.z_copy.logD
import com.githubyss.common.res.common.dimen.SpaceNormal
import com.githubyss.common.res.page.pageBgLightGray


/**
 * ComposeToolbarActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/24 16:03:36
 */
class ComposeToolbarActivity : BaseComposeToolbarActivity() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { ComposeToolbarActivity::class.java.simpleName }
    }


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Toolbar() {
        TopNavigationBar(getStringFromRes(R.string.combase_compose_toolbar_title)) { onBackPressed() }
    }

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            background = Color.pageBgLightGray,
            verticalArrangement = Arrangement.Center,
            paddingVertical = Dp.SpaceNormal,
        ) {
            val title = getStringFromRes(R.string.combase_compose_toolbar)
            logD(TAG, title)
            InfoDisplay(title = title)
        }
    }
}
