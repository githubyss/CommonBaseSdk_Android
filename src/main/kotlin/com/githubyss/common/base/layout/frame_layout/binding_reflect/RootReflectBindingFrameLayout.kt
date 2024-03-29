package com.githubyss.common.base.layout.frame_layout.binding_reflect

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.layout.frame_layout.classical.BaseFrameLayout
import com.githubyss.common.base.z_copy.logE
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType


/**
 * RootReflectBindingFrameLayout
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/04/08 11:39:37
 */
abstract class RootReflectBindingFrameLayout<B : ViewDataBinding> @Suppress("LeakingThis") @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseFrameLayout(context, attrs, defStyleAttr) {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { RootReflectBindingFrameLayout::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var _binding: B
    val binding: B get() = _binding


    /** ****************************** Constructors ****************************** */

    /**  */
    init {
        // Call inflate method to fill view according to specified ViewBinding by using java reflect.
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            try {
                /**
                 * 对应方法
                 * Class<B>.inflate(LayoutInflater.from(context), this, true)
                 */
                val clazz = type.actualTypeArguments[0] as Class<B>?
                val inflateMethod: Method? = clazz?.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
                val inflater = LayoutInflater.from(context)
                val container = this
                _binding = inflateMethod?.invoke(null, inflater, container, true) as B
            }
            catch (e: NoSuchMethodException) {
                logE(TAG, e::class.java.simpleName, e)
            }
            catch (e: IllegalAccessException) {
                logE(TAG, e::class.java.simpleName, e)
            }
            catch (e: InvocationTargetException) {
                logE(TAG, e::class.java.simpleName, e)
            }
        }
    }
}
