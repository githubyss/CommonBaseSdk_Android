package com.githubyss.common.base.activity_fragment.binding_reflect_root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.classical.BaseFragment
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType


/**
 * RootReflectBindingFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/04/08 11:27:32
 */
abstract class RootReflectBindingFragment<B : ViewDataBinding> : BaseFragment() {

    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var _binding: B
    val binding get() = _binding


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Call inflate method to fill view according to specified ViewDataBinding by using java reflect.
        var type = javaClass.genericSuperclass
        while (type !is ParameterizedType) {
            type = (type as Class<*>).genericSuperclass
        }
        if (type is ParameterizedType) {
            try {
                /**
                 * 对应方法
                 * Class<B>.inflate(inflater, container, false)
                 */
                val clazz = (type.actualTypeArguments[0]) as Class<B>
                val methodInflate = clazz.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
                _binding = (methodInflate.invoke(null, inflater, container, false)) as B

                // 这个写法有问题，会崩溃
                // _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
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

        return binding.root.apply {
            // 防止 Fragment 点击事件穿透
            setOnTouchListener { _, _ -> true }
        }
    }

    /**  */
    override fun onDestroyView() {
        _binding.unbind()
        // _binding = null
        super.onDestroyView()
    }
}
