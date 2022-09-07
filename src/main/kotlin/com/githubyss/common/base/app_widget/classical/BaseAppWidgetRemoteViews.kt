package com.githubyss.common.base.app_widget.classical

import android.content.Context
import android.widget.RemoteViews
import androidx.annotation.LayoutRes


/**
 * BaseAppWidgetRemoteViews
 * 子类 XxxWidgetRemoteViews 封装具体业务 Widget 的 RemoteViews，复用 Widget 的视图处理逻辑，可以通过 XxxWidgetRemoteViews(Context) 创建具体业务的 RemoteViews 实例，提供给刷新界面处使用。
 *
 * 刷新视图方法：
 * - AppWidgetManager.getInstance(Context).updateAppWidget(ComponentName, RemoteViews)
 * - AppWidgetManager.getInstance(Context).updateAppWidget(WidgetIds, RemoteViews)
 * - AppWidgetManager.getInstance(Context).updateAppWidget(WidgetId, RemoteViews)
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/09/07 10:29:31
 */
abstract class BaseAppWidgetRemoteViews(context: Context?, @LayoutRes layoutId: Int) : RemoteViews(context?.packageName, layoutId)
