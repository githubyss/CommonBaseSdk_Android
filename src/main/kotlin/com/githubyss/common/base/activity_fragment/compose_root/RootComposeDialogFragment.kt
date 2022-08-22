package com.githubyss.common.base.activity_fragment.compose_root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.githubyss.common.base.activity_fragment.classical.BaseDialogFragment
import com.githubyss.common.base.activity_fragment.classical.BaseFragment
import com.githubyss.common.base.activity_fragment.interface_default.BaseComposeInterface


/**
 * RootComposeDialogFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 10:58:02
 */
abstract class RootComposeDialogFragment : BaseDialogFragment(), BaseComposeInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Root {
                    Page()
                }
            }
        }
    }
}
