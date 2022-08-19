package com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githubyss.common.base.app.page.mvvm_binding.child.MvvmChildVm
import com.githubyss.common.base.app.page.mvvm_binding.enumeration.DisplayType


/**
 * MvvmViewModelByLiveData
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/06/11 11:12:44
 */
class MvvmViewModelByLiveData : ViewModel() {

    /** ****************************** Properties ****************************** */

    /** context */
    // var context: Activity? = null
    // var viewStyle = ViewStyle()

    /** 命令绑定（command） */
    // val onButtonShowCommand=ReplyCom

    /** 子 ViewModel */
    val itemViewModel by lazy { MutableLiveData<MvvmChildVm>() }

    /** 数据绑定，绑定到 UI 的字段（data field） */
    val displayType by lazy { MutableLiveData<String>() }


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        loadData()
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCleared() {
        super.onCleared()
        clearData()
    }


    /** ****************************** Functions ****************************** */

    /** ******************** Data Handling ******************** */

    /**  */
    private fun loadData() {
        this.displayType.value = DisplayType.TEXT
    }

    /**  */
    private fun clearData() {
    }

    /** ******************** Event Handling ******************** */

    /**  */
    fun onButtonSwitchTextClick() {
        this.displayType.value = DisplayType.TEXT
    }

    /**  */
    fun onButtonSwitchImageClick() {
        this.displayType.value = DisplayType.IMAGE
    }

    /**  */
    fun onButtonSwitchEdittextClick() {
        this.displayType.value = DisplayType.EDITTEXT
    }


    /** ****************************** Class ****************************** */

    // /**  */
    // class ViewStyle {
    //     var isTimeShow = ObservableBoolean()
    // }
}
