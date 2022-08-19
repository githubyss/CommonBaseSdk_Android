package com.githubyss.common.base.app.page.lifecycle

import android.view.View
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect_view_model.BaseReflectBindingViewModelToolbarFragment
import com.githubyss.common.base.databinding.CombaseFragmentLifecycleNextBinding


/**
 * LifecycleNextFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/15 10:40:03
 */
class LifecycleNextFragment : BaseReflectBindingViewModelToolbarFragment<CombaseFragmentLifecycleNextBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = LifecycleNextFragment::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private val onClickPresenter by lazy { OnClickPresenter() }


    /** ****************************** Override ****************************** */

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_lifecycle_title)
    }

    /**  */
    override fun bindXmlData() {
        binding.onClickPresenter = onClickPresenter
    }

    /**  */
    override fun observeViewModelData() {
    }

    /**  */
    override fun removeViewModelObserver() {
    }


    /** ****************************** Class ****************************** */

    /**  */
    inner class OnClickPresenter {
        fun onBack(v: View) {
            activity?.onBackPressed()
        }
    }
}
