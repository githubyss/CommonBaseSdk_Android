package com.githubyss.common.base.activity_fragment.compose_root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.githubyss.common.base.activity_fragment.classical.BaseFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseComposeInterface


/**
 * RootComposeFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/22 15:51:20
 */
abstract class RootComposeFragment : BaseFragment(), BaseComposeInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Root {
                    Page()
                }
            }
            // 防止 Fragment 点击事件穿透
            setOnTouchListener { _, _ -> true }
        }
    }
}
