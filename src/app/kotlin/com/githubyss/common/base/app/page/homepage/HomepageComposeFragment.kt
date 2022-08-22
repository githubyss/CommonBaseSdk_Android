package com.githubyss.common.base.app.page.homepage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.fragment.app.viewModels
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.classical.BaseActivity
import com.githubyss.common.base.activity_fragment.compose.BaseComposeToolbarFragment
import com.githubyss.common.base.app.page.binding_inline.InlineActivity
import com.githubyss.common.base.app.page.binding_inline.InlineToolbarActivity
import com.githubyss.common.base.app.page.binding_reflect.ReflectActivity
import com.githubyss.common.base.app.page.binding_reflect.ReflectToolbarActivity
import com.githubyss.common.base.app.page.compose.ComposeActivity
import com.githubyss.common.base.app.page.compose.ComposeToolbarActivity
import com.githubyss.common.base.app.page.lifecycle.LifecycleActivity
import com.githubyss.common.base.app.page.mvi.MviActivity
import com.githubyss.common.base.app.page.mvvm_binding.MvvmActivity
import com.githubyss.common.base.app.page.mvvm_binding.MvvmFragment
import com.githubyss.common.base.app.page.mvvm_compose.MvvmComposeActivity
import com.githubyss.common.base.app.page.state_compose.StateComposeActivity
import com.githubyss.common.base.app.z_copy.compose_ui.ButtonClickBlueWeightHorizontal
import com.githubyss.common.base.app.z_copy.compose_ui.LayoutWeightHorizontal
import com.githubyss.common.base.app.z_copy.compose_ui.PageSidePadding
import com.githubyss.common.base.app.z_copy.compose_ui.TopNavigationBar
import com.githubyss.common.base.app.z_copy.getStringFromRes
import com.githubyss.common.base.app.z_copy.startActivityExt
import com.githubyss.common.base.z_copy.switchFragmentByAddHideShow
import com.githubyss.mobile.common.res.common.dimen.SpaceNormal


/**
 * HomepageComposeFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/03/30 17:50:30
 */
class HomepageComposeFragment : BaseComposeToolbarFragment() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        val TAG: String = HomepageComposeFragment::class.java.simpleName
    }

    /**  */
    private val homepageVm by viewModels<HomepageComposeViewModel>()


    /** ****************************** Override ****************************** */

    /**  */
    @Composable
    override fun Toolbar() {
        TopNavigationBar(homepageVm.title)
    }

    /**  */
    @Composable
    override fun Content() {
        PageSidePadding(
            paddingVertical = Dp.SpaceNormal,
        ) {
            Buttons()
        }
    }


    /** ****************************** Functions ****************************** */

    /**  */
    @Composable
    private fun Buttons() {
        LayoutWeightHorizontal {
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_compose),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, ComposeActivity::class.java)
                // switchFragmentByAddHideShow(ComposeFragment(), ComposeFragment.TAG, this, parentFragmentManager, true)
            }
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_compose_toolbar),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, ComposeToolbarActivity::class.java)
                // switchFragmentByAddHideShow(ComposeToolbarFragment(), ComposeToolbarFragment.TAG, this, parentFragmentManager, true)
            }
        }
        LayoutWeightHorizontal {
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_view_binding_reflect),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, ReflectActivity::class.java)
            }
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_view_binding_reflect_toolbar),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, ReflectToolbarActivity::class.java)
            }
        }
        LayoutWeightHorizontal {
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_view_binding_inline),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, InlineActivity::class.java)
            }
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_view_binding_inline_toolbar),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, InlineToolbarActivity::class.java)
            }
        }
        LayoutWeightHorizontal {
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_mvvm_binding_activity),
                modifier = Modifier.weight(1F),
            ) {
                startActivityExt(activity, MvvmActivity::class.java)
            }
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_mvvm_binding_fragment),
                modifier = Modifier.weight(1F),
            ) {
                switchFragmentByAddHideShow(MvvmFragment(), MvvmFragment.TAG, this, parentFragmentManager, BaseActivity.FRAGMENT_BASE_CONTAINER_ID, true)
            }
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_mvvm_compose),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, MvvmComposeActivity::class.java)
            }
        }
        LayoutWeightHorizontal {
            ButtonClickBlueWeightHorizontal(
                text = getStringFromRes(R.string.combase_homepage_button_state_compose),
                modifier = Modifier.weight(1F)
            ) {
                startActivityExt(activity, StateComposeActivity::class.java)
            }
        }
        ButtonClickBlueWeightHorizontal(text = getStringFromRes(R.string.combase_homepage_button_mvi)) {
            startActivityExt(activity, MviActivity::class.java)
        }
        ButtonClickBlueWeightHorizontal(
            text = getStringFromRes(R.string.combase_homepage_button_lifecycle),
        ) {
            startActivityExt(activity, LifecycleActivity::class.java)
        }
    }
}