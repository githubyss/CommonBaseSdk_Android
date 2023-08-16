package com.githubyss.common.base.activity_fragment.binding_reflect_root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.githubyss.common.base.activity_fragment.classical.BaseDialogFragment
import com.githubyss.common.base.z_copy.logE
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType


/**
 * RootReflectBindingDialogFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/25 16:30:44
 */
abstract class RootReflectBindingDialogFragment<B : ViewDataBinding> : BaseDialogFragment() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { RootReflectBindingDialogFragment::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var _binding: B
    val binding get() = _binding


    /** ****************************** Override ****************************** */

    /**  */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Call inflate method to fill view according to specified ViewBinding by using java reflect.
        var type = javaClass.genericSuperclass
        while (type !is ParameterizedType) {
            type = (type as Class<*>).genericSuperclass
        }
        if (type is ParameterizedType) {
            try {
                val clazz = (type.actualTypeArguments[0]) as Class<B>
                val methodInflate = clazz.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
                _binding = (methodInflate.invoke(null, inflater, container, false)) as B

                // 这个写法有问题，会崩溃
                // _binding = DataBindingUtil.inflate<B>(inflater, layoutId, container, false)
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

        return binding.root
    }

    /**  */
    override fun onDestroyView() {
        _binding.unbind()
        // _binding = null
        super.onDestroyView()
    }
}
