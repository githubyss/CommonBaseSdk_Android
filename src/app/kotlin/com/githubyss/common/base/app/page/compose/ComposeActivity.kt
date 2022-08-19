package com.githubyss.common.base.app.page.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeActivity
import com.githubyss.common.base.app.compose_ui.InfoDisplay
import com.githubyss.common.base.app.z_copy.comui.PageSidePadding
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.mobile.common.res.common.dimen.SpaceNormal


/**
 * ComposeActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/23 15:49:58
 */
class ComposeActivity : BaseComposeActivity() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = ComposeActivity::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            background = Color.Black,
            verticalArrangement = Arrangement.Center,
            paddingVertical = Dp.SpaceNormal,
        ) {
            InfoDisplay(title = getStringFromRes(R.string.combase_compose))
        }
    }
}
