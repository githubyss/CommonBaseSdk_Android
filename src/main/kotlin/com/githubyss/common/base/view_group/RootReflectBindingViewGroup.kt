package com.githubyss.common.base.view_group

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.activity_fragment.classical.BaseFragment
import com.githubyss.common.base.frame_layout.classical.BaseFrameLayout
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType


/**
 * RootReflectBindingViewGroup
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/22 16:58:04
 */
abstract class RootReflectBindingViewGroup<B : ViewDataBinding> @Suppress("LeakingThis") @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : BaseViewGroup(context, attrs, defStyleAttr) {

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
                val clazz = type.actualTypeArguments[0] as Class<B>?
                val inflateMethod: Method? = clazz?.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
                val inflater = LayoutInflater.from(context)
                val container = this
                _binding = inflateMethod?.invoke(null, inflater, container, true) as B
            }
            catch (e: NoSuchMethodException) {
                println("$TAG $e")
            }
            catch (e: IllegalAccessException) {
                println("$TAG $e")
            }
            catch (e: InvocationTargetException) {
                println("$TAG $e")
            }
        }
    }
}
