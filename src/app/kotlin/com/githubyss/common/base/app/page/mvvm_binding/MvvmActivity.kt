package com.githubyss.common.base.app.page.mvvm_binding

import android.view.View
import androidx.activity.viewModels
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect_view_model.BaseReflectBindingViewModelToolbarActivity
import com.githubyss.common.base.app.page.mvvm_binding.enumeration.DisplayType
import com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data.MvvmEdittextVmByLiveData
import com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data.MvvmImageVmByLiveData
import com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data.MvvmTextVmByLiveData
import com.githubyss.common.base.app.page.mvvm_binding.view_model.live_data.MvvmViewModelByLiveData
import com.githubyss.common.base.app.page.mvvm_binding.view_model.observable_field.MvvmEdittextVmByObservableField
import com.githubyss.common.base.app.page.mvvm_binding.view_model.observable_field.MvvmImageVmByObservableField
import com.githubyss.common.base.app.page.mvvm_binding.view_model.observable_field.MvvmTextVmByObservableField
import com.githubyss.common.base.app.page.mvvm_binding.view_model.observable_field.MvvmViewModelByObservableField
import com.githubyss.common.base.databinding.CombaseFragmentMvvmBinding
import com.githubyss.common.base.z_copy.logD


/**
 * MvvmActivity
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/07/15 14:47:57
 */
class MvvmActivity : BaseReflectBindingViewModelToolbarActivity<CombaseFragmentMvvmBinding>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        private val TAG by lazy { MvvmActivity::class.java.simpleName }
    }


    /** ****************************** Properties ****************************** */

    /**  */
    // private val mvvmVmLiveData: MvvmViewModelByLiveData by lazy { ViewModelProvider(requireActivity()).get(MvvmViewModelByLiveData::class.java) }
    private val mvvmVmLiveData: MvvmViewModelByLiveData by viewModels()
    private val mvvmTextVmLiveData: MvvmTextVmByLiveData by viewModels()
    private val mvvmImageVmLiveData: MvvmImageVmByLiveData by viewModels()
    private val mvvmEdittextVmLiveData: MvvmEdittextVmByLiveData by viewModels()

    // private val mvvmVmObservableField: MvvmViewModelByObservableField by lazy { ViewModelProvider(requireActivity()).get(MvvmViewModelByObservableField::class.java) }
    private val mvvmVmObservableField: MvvmViewModelByObservableField by viewModels()
    private val mvvmTextVmObservableField: MvvmTextVmByObservableField by viewModels()
    private val mvvmImageVmObservableField: MvvmImageVmByObservableField by viewModels()
    private val mvvmEdittextVmObservableField: MvvmEdittextVmByObservableField by viewModels()


    /** ****************************** Override ****************************** */

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_mvvm_title)
    }

    /**  */
    override fun bindLifecycleOwner() {
        binding.lifecycleOwner = this
    }

    /**  */
    override fun bindXmlData() {
        binding.mvvmVm = this.mvvmVmLiveData
        binding.layoutText.mvvmVm = this.mvvmTextVmLiveData
        // binding.layoutImage.mvvmVm = this.mvvmImageVmLiveData
        binding.layoutEdittext.mvvmVm = this.mvvmEdittextVmLiveData

        // binding.mvvmVm = this.mvvmVmObservableField
        // binding.layoutText.mvvmVm = this.mvvmTextVmObservableField
        binding.layoutImage.mvvmVm = this.mvvmImageVmObservableField
        // binding.layoutEdittext.mvvmVm = this.mvvmEdittextVmObservableField
    }

    /**  */
    override fun observeViewModelData() {
        observeVmByLiveData()
        // observeVmByObservableField()
    }

    /**  */
    override fun removeViewModelObserver() {
        removeVmObserverByLiveData()
        // removeVmObserverByObservableField()
    }


    /** ****************************** Functions ****************************** */

    /**  */
    private fun observeVmByLiveData() {
        // this.mvvmVmLiveData.displayType.observe(this, changeObserverByLiveData)
        this.mvvmEdittextVmLiveData.edittext.observe(this) {
            logD(TAG, "edittext: $it")
        }
    }

    /**  */
    private fun observeVmByObservableField() {
        // this.mvvmVmObservableField.displayType.addOnPropertyChangedCallback(changeObserverByObservableField)
        // this.mvvmVmObservableField.displayType.notifyChange()
    }

    /**  */
    private fun removeVmObserverByLiveData() {
        // this.mvvmVmLiveData.displayType.removeObservers(this)
        this.mvvmEdittextVmLiveData.edittext.removeObservers(this)
    }

    /**  */
    private fun removeVmObserverByObservableField() {
        // this.mvvmVmObservableField.displayType.removeOnPropertyChangedCallback(changeObserverByObservableField)
    }


    /** ****************************** Implementations ****************************** */

    /**  */
    private val changeObserverByLiveData = Observer<String> { t ->
        when (t) {
            DisplayType.TEXT -> {
                binding.layoutText.flexboxText.visibility = View.VISIBLE
                binding.layoutImage.flexboxImage.visibility = View.GONE
                binding.layoutEdittext.flexboxEdittext.visibility = View.GONE
            }
            DisplayType.IMAGE -> {
                binding.layoutText.flexboxText.visibility = View.GONE
                binding.layoutImage.flexboxImage.visibility = View.VISIBLE
                binding.layoutEdittext.flexboxEdittext.visibility = View.GONE
            }
            DisplayType.EDITTEXT -> {
                binding.layoutText.flexboxText.visibility = View.GONE
                binding.layoutImage.flexboxImage.visibility = View.GONE
                binding.layoutEdittext.flexboxEdittext.visibility = View.VISIBLE
            }
        }
    }

    /**  */
    private val changeObserverByObservableField = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            when (mvvmVmObservableField.displayType.get()) {
                DisplayType.TEXT -> {
                    binding.layoutText.flexboxText.visibility = View.VISIBLE
                    binding.layoutImage.flexboxImage.visibility = View.GONE
                    binding.layoutEdittext.flexboxEdittext.visibility = View.GONE
                }
                DisplayType.IMAGE -> {
                    binding.layoutText.flexboxText.visibility = View.GONE
                    binding.layoutImage.flexboxImage.visibility = View.VISIBLE
                    binding.layoutEdittext.flexboxEdittext.visibility = View.GONE
                }
                DisplayType.EDITTEXT -> {
                    binding.layoutText.flexboxText.visibility = View.GONE
                    binding.layoutImage.flexboxImage.visibility = View.GONE
                    binding.layoutEdittext.flexboxEdittext.visibility = View.VISIBLE
                }
            }
        }
    }
}
