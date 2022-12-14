package com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * MvvmEdittextVmByLiveData
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/21 13:55:55
 */
class MvvmEdittextVmByLiveData : ViewModel() {

    /** ****************************** Properties ****************************** */

    /** 数据绑定，绑定到 UI 的字段（data field） */
    val edittext by lazy { MutableLiveData<String>() }


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
        this.edittext.value = ""
    }

    /**  */
    private fun clearData() {
    }

    /** ******************** Event Handling ******************** */

    /**  */
    fun afterTextChanged(value: Editable) {
        this.edittext.value = value.toString()
    }
}
