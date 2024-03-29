package com.githubyss.common.base.app_widget.classical

import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.githubyss.common.base.app_widget.interface_default.BaseAppWidgetRemoteViewsFactoryInterface
import com.githubyss.common.base.z_copy.logV


/**
 * BaseAppWidgetRemoteViewsFactory
 * 提供了 RemoteViewsFactory 用于填充远程集合视图。
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/29 18:00:34
 */
abstract class BaseAppWidgetRemoteViewsFactory<T> : RemoteViewsService.RemoteViewsFactory, BaseAppWidgetRemoteViewsFactoryInterface {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseAppWidgetRemoteViewsFactory::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val factoryName by lazy { this::class.simpleName }

    protected open val dataList by lazy { ArrayList<T>() }


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        logV(TAG, "$factoryName constructor init.")
    }


    /** ****************************** Override ****************************** */

    /**
     * RemoteViewsFactory 调用时执行，这个方法执行时间超过 20 秒会报错。
     * 如果耗时长的任务应该在 onDataSetChanged 或者 getViewAt 中处理
     */
    override fun onCreate() {
        val message = "$factoryName > onCreate"
        logV(TAG, message)

        setupData()
    }

    /**
     * 当调 AppWidgetManager 的 notifyAppWidgetViewDataChanged 方法时，触发这个方法。
     * 例如：AppWidgetManager.getInstance(context).notifyAppWidgetViewDataChanged(appWidgetIds, viewId)
     * 经过实际测试，在触发 notifyAppWidgetViewDataChanged 方法时不会立刻调用到 onDataSetChanged，而是当回到桌面的时候，才会走到 onDataSetChanged，进行 Widget 数据刷新
     */
    override fun onDataSetChanged() {
        val message = "$factoryName > onDataSetChanged"
        logV(TAG, message)

        updateData()
    }

    /** 这里写情理资源，释放内存的操作 */
    override fun onDestroy() {
        val message = "$factoryName > onDestroy"
        logV(TAG, message)

        dataList.clear()
        clearData()
    }

    /** 创建并且填充，在指定索引位置显示 View，这个和 BaseAdapter 的 getView 类似 */
    override fun getViewAt(position: Int): RemoteViews? {
        val message = "$factoryName > getViewAt position: $position"
        logV(TAG, message)

        return refreshView(position)
    }

    /** 返回集合数量 */
    override fun getCount(): Int {
        val message = "$factoryName > getCount"
        logV(TAG, message)

        return dataList.size
    }

    /** 返回当前的索引。 */
    override fun getItemId(position: Int): Long {
        val message = "$factoryName > getItemId"
        logV(TAG, message)

        return position.toLong()
    }

    /** 不同 View 定义的数量。默认为 1 */
    override fun getViewTypeCount(): Int {
        val message = "$factoryName > getViewTypeCount"
        logV(TAG, message)

        return 1
    }

    /**
     * 在更新界面的时候如果耗时就会显示正在加藏...的默认字样，但是你可以更改这个界面
     * 如果返回 null 显示默认界面
     * 否则加截自定义的，返回 RemoteViews
     */
    override fun getLoadingView(): RemoteViews? {
        val message = "$factoryName > getLoadingView"
        logV(TAG, message)

        return null
    }

    /** 如果每个项提供的 ID 是稳定的，即它们不会在运行时改变，就返回 true (没用过。。。) */
    override fun hasStableIds(): Boolean {
        val message = "$factoryName > hasStableIds"
        logV(TAG, message)

        return false
    }
}
