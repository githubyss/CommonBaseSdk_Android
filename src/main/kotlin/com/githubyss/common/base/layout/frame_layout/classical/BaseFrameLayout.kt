package com.githubyss.common.base.layout.frame_layout.classical

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import com.githubyss.common.base.z_copy.logV


/**
 * BaseFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:37:26
 */
abstract class BaseFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseFrameLayout::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val thisClassName by lazy { this::class.java.simpleName }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val message = "$thisClassName > onDraw"
        logV(TAG, message)
    }

    /**  */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val message = "$thisClassName > onMeasure {widthMeasureSpec:$widthMeasureSpec, heightMeasureSpec:$heightMeasureSpec}"
        logV(TAG, message)
    }

    /**  */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        val message = "$thisClassName > onLayout {changed:$changed, left:$left, top:$top, right:$right, bottom:$bottom}"
        logV(TAG, message)
    }
}
