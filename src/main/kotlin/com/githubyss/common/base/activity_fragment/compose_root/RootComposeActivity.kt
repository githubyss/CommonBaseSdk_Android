package com.githubyss.common.base.activity_fragment.compose_root

import android.os.Bundle
import androidx.activity.compose.setContent
import com.githubyss.common.base.activity_fragment.classical.BaseActivity
import com.githubyss.common.base.activity_fragment.interface_default.BaseComposeInterface


/**
 * RootComposeActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/24 15:43:29
 */
abstract class RootComposeActivity : BaseActivity(), BaseComposeInterface {

    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            Root {
                Page()
            }
        }

        super.onCreate(savedInstanceState)
    }
}
