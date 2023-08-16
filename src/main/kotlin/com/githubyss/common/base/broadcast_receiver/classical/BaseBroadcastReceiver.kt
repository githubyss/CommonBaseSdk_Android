package com.githubyss.common.base.broadcast_receiver.classical

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.githubyss.common.base.app_widget.classical.BaseAppWidget
import com.githubyss.common.base.z_copy.logV


/**
 * BaseBroadcastReceiver
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/29 21:13:51
 */
class BaseBroadcastReceiver : BroadcastReceiver() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseBroadcastReceiver::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private var broadcastReceiverName = this::class.java.simpleName


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        logV(TAG, "$broadcastReceiverName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = "$broadcastReceiverName > onReceive, 接收到广播 intent: $intent"
        logV(TAG, message)
    }
}
