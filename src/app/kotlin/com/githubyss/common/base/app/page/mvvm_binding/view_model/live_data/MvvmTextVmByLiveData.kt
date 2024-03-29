package com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.githubyss.common.base.app.page.mvvm_binding.enumeration.TimeOperateState
import com.githubyss.common.base.app.page.mvvm_binding.model.MvvmModel
import com.githubyss.common.base.app.z_copy.cancelTimer
import com.githubyss.common.base.app.z_copy.runTaskPeriodicallyWithTimeOffset
import java.util.*
import kotlin.concurrent.timerTask


/**
 * MvvmTextVmByLiveData
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/21 13:47:52
 */
class MvvmTextVmByLiveData : ViewModel() {

    /** ****************************** Properties ****************************** */

    /** model（数据源 Java Bean） */
    private var textBean: MvvmModel.TextBean? = null

    /** 数据绑定，绑定到 UI 的字段（data field） */
    val text by lazy { MutableLiveData<String>() }
    val isTimeShow by lazy { MutableLiveData<Boolean>() }
    val timeOperateState by lazy { MutableLiveData<TimeOperateState>() }


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
        this.textBean = MvvmModel.TextBean("请点击开始！")

        this.text.value = textBean?.text
        this.isTimeShow.value = true
        this.timeOperateState.value = TimeOperateState.START
    }

    /**  */
    private fun clearData() {
        this.textBean = null
    }

    /** ******************** Event Handling ******************** */

    /**  */
    fun onButtonOperateTimeClick() {
        when (this.timeOperateState.value) {
            TimeOperateState.START -> {
                this.timeOperateState.value = TimeOperateState.STOP
                runTaskPeriodicallyWithTimeOffset(timerTask {
                    this@MvvmTextVmByLiveData.text.postValue("当前时间: ${System.currentTimeMillis()}")
                }, 0, 500)
            }
            TimeOperateState.STOP -> {
                this.timeOperateState.value = TimeOperateState.START
                cancelTimer()
            }
            else -> {}
        }
    }

    /**  */
    fun onButtonShowTimeTextClick() {
        this.isTimeShow.value = true
    }

    /**  */
    fun onButtonHideTimeTextClick() {
        this.isTimeShow.value = false
    }
}
