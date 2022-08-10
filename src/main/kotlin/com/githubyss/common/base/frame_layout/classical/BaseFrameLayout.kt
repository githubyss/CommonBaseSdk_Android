package com.githubyss.common.base.frame_layout.classical

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout


/**
 * BaseFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:37:26
 */

abstract class BaseFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    /** ****************************** Companion ****************************** */

    /**  */
    companion object {
        val TAG: String = BaseFrameLayout::class.java.simpleName
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val message = "${this::class.java.simpleName} > onDraw"
        println("$TAG $message")
    }

    /**  */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val message = "${this::class.java.simpleName} > onMeasure"
        println("$TAG $message")
    }

    /**  */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        val message = "${this::class.java.simpleName} > onLayout"
        println("$TAG $message")
    }
}
