package com.githubyss.common.base.activity_fragment.compose_root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.githubyss.common.base.activity_fragment.classical.BaseFragment


/**
 * RootComposeFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/22 15:51:20
 */
abstract class RootComposeFragment : BaseFragment() {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Page()
            }
        }
    }


    /** ****************************** Abstract ****************************** */

    /**  */
    @Composable
    abstract fun Page()

    /**  */
    @Composable
    abstract fun Content()
}