package com.githubyss.common.base.recycler_view.classical

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.githubyss.common.base.z_copy.logV


/**
 * BaseRecyclerView
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/10 13:57:40
 */
abstract class BaseRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { BaseRecyclerView::class.java.simpleName }
    }


    /** ****************************** Override ****************************** */

    /**  */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val message = "$TAG > onDraw"
        logV(TAG, message)
    }

    /**  */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val message = "$TAG > onMeasure"
        logV(TAG, message)
    }

    /**  */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        val message = "$TAG > onLayout"
        logV(TAG, message)
    }
}
