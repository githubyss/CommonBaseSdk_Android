package com.githubyss.common.base.app.page.mvvm_compose

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarActivity
import com.githubyss.common.base.app.page.mvvm_compose.view_model.MvvmComposeViewModelByState
import com.githubyss.common.base.app.z_copy.compose_ui.ButtonClickBlueMargin
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.mobile.common.res.common.dimen.SpaceNormal


/**
 * MvvmComposeActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/03/08 17:46:28
 */
class MvvmComposeActivity : BaseComposeToolbarActivity() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = MvvmComposeActivity::class.java.simpleName
    }

    private val composeVm: MvvmComposeViewModelByState by viewModels()

    private val titleDefault = getStringFromRes(R.string.combase_compose_toolbar_title)


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Toolbar() {
        TopNavigationBar(composeVm.title) { onBackPressed() }
    }

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            paddingVertical = Dp.SpaceNormal,
        ) {
            ChangeTitleButton()
            CounterButtonByCountOutside()
        }
    }


    /** ****************************** Functions ****************************** */

    /**  */
    @Composable
    private fun ChangeTitleButton() {
        ButtonClickBlueMargin(
            text = "Change Title",
            isFillMaxWidth = true,
        ) {
            composeVm.changeTitle("$titleDefault ${composeVm.count}")
        }
    }

    /**  */
    @Composable
    private fun CounterButtonByCountOutside() {
        ButtonClickBlueMargin(
            text = "Counter Outside : ${composeVm.count}",
            isFillMaxWidth = true,
        ) {
            composeVm.plus()
        }
    }
}