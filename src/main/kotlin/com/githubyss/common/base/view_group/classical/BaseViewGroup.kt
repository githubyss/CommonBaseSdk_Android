package com.githubyss.common.base.view_group.classical

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup


/**
 * BaseViewGroup
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 16:53:51
 */
@Deprecated("ViewGroup 方案无法渲染出来布局")
abstract class BaseViewGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ViewGroup(context, attrs, defStyleAttr) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = BaseViewGroup::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private var thisClassName = this::class.java.simpleName


    /** ****************************** Override ****************************** */

    /**  */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val message = "$thisClassName > onDraw"
        println("$TAG $message")
    }

    /**  */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val message = "$thisClassName > onMeasure {widthMeasureSpec:$widthMeasureSpec, heightMeasureSpec:$heightMeasureSpec}"
        println("$TAG $message")
    }

    /**  */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        // super.onLayout(changed, left, top, right, bottom)

        val message = "$thisClassName > onLayout {changed:$changed, left:$left, top:$top, right:$right, bottom:$bottom}"
        println("$TAG $message")
    }
}
