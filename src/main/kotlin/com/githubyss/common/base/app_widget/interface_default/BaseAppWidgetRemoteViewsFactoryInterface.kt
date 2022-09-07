package com.githubyss.common.base.app_widget.interface_default

import android.widget.RemoteViews


/**
 * BaseAppWidgetRemoteViewsFactoryInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/09/05 18:05:28
 */
interface BaseAppWidgetRemoteViewsFactoryInterface {
    /** 初始化数据 */
    fun setupData() {}

    /** 更新数据 */
    fun updateData() {}

    /** 清空数据 */
    fun clearData() {}

    /** 刷新视图 */
    fun refreshView(position: Int): RemoteViews? {return null}
}
