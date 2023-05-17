package com.githubyss.common.base.ext

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.githubyss.common.base.ext.inflateBindingByLayoutInflater
import com.githubyss.common.base.recycler_view.binding_inline_root.RootInlineBindingViewHolder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


/**
 * 通过 ViewGroup 获取 binding
 */
inline fun <reified B : ViewDataBinding> inflateBinding(parent: ViewGroup): Lazy<B> {
    return lazy { inflateBindingByViewGroup<B>(parent) }
}

/** 通过 LayoutInflater 获取 Activity 的 binding */
inline fun <reified B : ViewDataBinding> Activity.inflateBinding(): Lazy<B> {
    return lazy { inflateBindingByLayoutInflater<B>(layoutInflater).apply { setContentView(root) } }
}

/** 获取 Fragment 的 binding */
inline fun <reified B : ViewDataBinding> Fragment.inflateBinding() = FragmentBindingDelegate(B::class.java)
class FragmentBindingDelegate<B : ViewDataBinding>(private val clazz: Class<B>) : ReadOnlyProperty<Fragment, B> {
    private lateinit var _binding: B
    private val binding get() = _binding

    private var isInitialized = false

    override fun getValue(thisRef: Fragment, property: KProperty<*>): B {
        if (!isInitialized) {
            thisRef.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestroyView() {
                    _binding.unbind()
                    // _binding = null
                }
            })
            val methodBind = clazz.getMethod("bind", View::class.java)
            _binding = methodBind.invoke(null, thisRef.requireView()) as B

            isInitialized = true
        }
        return binding
    }
}
