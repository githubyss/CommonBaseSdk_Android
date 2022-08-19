package com.githubyss.common.base.app.page.mvvm_compose.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.githubyss.common.base.R
import com.githubyss.common.base.app.z_copy.getStringFromRes


/**
 * MvvmComposeViewModelByState
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/03/08 16:20:56
 */
class MvvmComposeViewModelByState : ViewModel() {

    /** ****************************** Properties ****************************** */

    /**  */
    private val titleDefault = getStringFromRes(R.string.combase_compose_toolbar_title)

    var title: String by mutableStateOf(titleDefault)
        private set
    var count: Int by mutableStateOf(0)
        private set


    /** ****************************** Functions ****************************** */

    /**  */
    fun changeTitle(title: String) {
        this.title = title
    }

    /**  */
    fun plus() {
        this.count++
    }
}