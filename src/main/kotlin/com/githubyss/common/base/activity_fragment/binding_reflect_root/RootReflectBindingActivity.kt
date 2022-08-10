package com.githubyss.common.base.activity_fragment.binding_reflect_root

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.classical.BaseActivity
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType


/**
 * RootReflectBindingActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2021/04/08 10:48:25
 */
abstract class RootReflectBindingActivity<B : ViewDataBinding> : BaseActivity() {

    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var _binding: B
    val binding get() = _binding


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call inflate method to fill view according to specified ViewBinding by using java reflect.
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            try {
                val clazz = (type.actualTypeArguments[0]) as Class<B>
                val methodInflate = clazz.getMethod("inflate", LayoutInflater::class.java)
                val inflater = layoutInflater
                _binding = (methodInflate.invoke(null, inflater)) as B
                setContentView(binding.root)
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

        super.onCreate(savedInstanceState)
    }

    /**  */
    override fun onDestroy() {
        _binding.unbind()
        super.onDestroy()
    }
}
