package com.githubyss.common.base.app.page.state_compose

import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarActivity
import com.githubyss.common.base.app.z_copy.compose_ui.ButtonClickBlueMargin
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.res.common.dimen.SpaceNormal


/**
 * StateComposeActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/03/30 16:41:43
 */
class StateComposeActivity : BaseComposeToolbarActivity() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        private val TAG: String = StateComposeActivity::class.java.simpleName
    }

    private val titleDefault = getStringFromRes(R.string.combase_compose_toolbar_title)

    private var title by mutableStateOf(titleDefault)
    // private var title: MutableState<String> = mutableStateOf(TITLE)

    private var count by mutableStateOf(0)
    // private var count: MutableState<Int> = mutableStateOf(0)


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Toolbar() {
        TopNavigationBar(title) { onBackPressed() }
    }

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            paddingVertical = Dp.SpaceNormal,
        ) {
            ChangeTitleButton()
            CounterButtonByCountOutside()
            CounterButtonByCountInside()
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
            title = "$titleDefault $count"
        }
    }

    /**  */
    @Composable
    private fun CounterButtonByCountOutside() {
        ButtonClickBlueMargin(
            text = "Counter Outside : $count",
            isFillMaxWidth = true,
        ) {
            count++
        }
    }

    /**  */
    @Composable
    private fun CounterButtonByCountInside() {
        var count: Int by remember { mutableStateOf(0) }
        // val count: MutableState<Int> = remember { mutableStateOf(0) }

        ButtonClickBlueMargin(
            text = "Counter Inside : $count",
            isFillMaxWidth = true,
        ) {
            count++
            // count.value++
        }
    }
}