package com.githubyss.common.base.app.application

import com.githubyss.common.base.application.BaseApplication


/**
 * CombaseApplication
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/08/24 19:34:38
 */
class CombaseApplication : BaseApplication() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG: String = CombaseApplication::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
