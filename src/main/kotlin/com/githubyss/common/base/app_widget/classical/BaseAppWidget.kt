package com.githubyss.common.base.app_widget.classical

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import com.githubyss.common.base.z_copy.logV


/**
 * BaseAppWidget
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/29 13:56:29
 */
abstract class BaseAppWidget : AppWidgetProvider() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseAppWidget::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val thisClassName by lazy { this::class.java.simpleName }


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        logV(TAG, "$thisClassName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**
     * 创建第一个 AppWidget 实例所调用的方法。
     * 当第一次创建该类型的 AppWidget 时，调用此方法。
     *
     * 当 Widget 首次拖进桌面时触发，这里我们一般可以进行一些变量初始的工作
     */
    override fun onEnabled(context: Context) {
        super.onEnabled(context)

        val message = "$thisClassName > onEnabled, 开始使用 Widget（同 Widget 第一个拖进桌面）"
        logV(TAG, message)
    }

    /**
     * 删除最后一个 AppWidget 所调用的方法。
     * 当该类型的窗口小部件 AppWidget 全被删除时，调用此方法。
     *
     * 当最后一个 Widget 拖出桌面后触发，这里我们一般可以进行一些清空重置的工作
     */
    override fun onDisabled(context: Context) {
        super.onDisabled(context)

        val message = "$thisClassName > onDisabled, 停止使用 Widget（同 Widget 最后一个拖出桌面）"
        logV(TAG, message)
    }

    /**
     * 到达指定的时间，或者用户每次创建 AppWidget 所调用的方法。
     * 每次创建该类型的 AppWidget 都会调用此方法，通常来说我们需要在该方法里为该 AppWidget 指定 RemoteViews 对象。
     *
     * 此方法一般处理 Widget 的创建布局和更新 UI 操作，当 Widget 添加到桌面会触发 onUpdate() 方法。
     * 我们可以在此里通过获取 RemoteViews 来给 Widget 加载一个布局，远程视图 RemoteViews 是 Widget 的资源管理工具，我们可以用来给 Widget 转换一个它支持布局，仅支持特定的 View。
     */
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val message = "$thisClassName > onUpdate, 将 Widget 拖进桌面了。appWidgetIds: ${appWidgetIds.contentToString()}"
        logV(TAG, message)
    }

    /**
     * 删除一个 AppWidget 所调用的方法。
     * 当该类型的 AppWidget 每次被删除时，调用此方法。
     *
     * Widget 被删除了，这里我们通常用于释放一些对象和视图资源，便于防止内存泄露。
     */
    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        val message = "$thisClassName > onDeleted, 将 Widget 拖出桌面了。appWidgetIds: ${appWidgetIds.contentToString()}"
        logV(TAG, message)

        super.onDeleted(context, appWidgetIds)
    }

    /**
     * 接收广播事件。
     * 广播接受者方法，用来接受广播消息。
     *
     * 此方功类似广播的 onReceive() 用法，用来接收和处理广播，如果我们在 manifest.xml 注册了 ScheduleWidget 为一个 AppWidget，那么不必须为此广播加上 Widget 标示，<intent-filter> 添加一个 action：<action android:name="android.appwidget.action.APPWIDGET_UPDATE"，下面的 <meta-data 标签用来定义 Widget 的属性，指定一个 Widget 描述信息
     */
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        val message = "$thisClassName > onReceive, 接收到广播 intent: $intent"
        logV(TAG, message)
    }
}
