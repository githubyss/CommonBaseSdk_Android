package com.githubyss.common.base.app.page.homepage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.githubyss.common.base.R
import com.githubyss.common.base.app.z_copy.getStringFromRes


/**
 * HomepageComposeViewModel
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/03/30 17:50:22
 */
class HomepageComposeViewModel : ViewModel() {

    /** ****************************** Properties ****************************** */

    /**  */
    private val titleDefault = getStringFromRes(R.string.combase_homepage_title)

    /** 数据绑定，绑定到 UI 的字段（data field） */
    var title: String by mutableStateOf(titleDefault)
        private set


    /** ****************************** Functions ****************************** */

    /**  */
    fun changeTitle(title: String) {
        this.title = title
    }
}
