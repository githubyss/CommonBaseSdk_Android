package com.githubyss.common.base.broadcast_receiver.classical

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.githubyss.common.base.app_widget.classical.BaseAppWidget


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
        val TAG: String = BaseBroadcastReceiver::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private var broadcastReceiverName = this::class.java.simpleName


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        println("$TAG $broadcastReceiverName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = "$broadcastReceiverName > onReceive, 接收到广播 intent: $intent"
        println("${BaseAppWidget.TAG} $message")
    }
}
