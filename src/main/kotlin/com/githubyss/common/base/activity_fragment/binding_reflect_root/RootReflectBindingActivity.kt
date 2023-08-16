package com.githubyss.common.base.activity_fragment.binding_reflect_root

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.classical.BaseActivity
import com.githubyss.common.base.z_copy.logE
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

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { RootReflectBindingActivity::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var _binding: B
    val binding get() = _binding


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call inflate method to fill view according to specified ViewDataBinding by using java reflect.
        var type = javaClass.genericSuperclass
        while (type !is ParameterizedType) {
            type = (type as Class<*>).genericSuperclass
        }
        if (type is ParameterizedType) {
            try {
                /**
                 * 对应方法
                 * Class<B>.inflate(layoutInflater)
                 */
                val clazz = (type.actualTypeArguments[0]) as Class<B>
                val methodInflate = clazz.getMethod("inflate", LayoutInflater::class.java)
                val inflater = layoutInflater
                _binding = (methodInflate.invoke(null, inflater)) as B
                setContentView(binding.root)
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

        super.onCreate(savedInstanceState)
    }

    /**  */
    override fun onDestroy() {
        _binding.unbind()
        super.onDestroy()
    }
}
