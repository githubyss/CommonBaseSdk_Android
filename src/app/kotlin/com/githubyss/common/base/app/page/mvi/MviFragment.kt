package com.githubyss.common.base.app.page.mvi

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.githubyss.common.base.R
import com.githubyss.common.base.activity_fragment.binding_reflect_view_model.BaseReflectBindingViewModelToolbarFragment
import com.githubyss.common.base.app.page.mvi.model.User
import com.githubyss.common.base.databinding.CombaseFragmentMviBinding
import kotlinx.coroutines.launch


/**
 * MviFragment
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/02/17 17:31:31
 */
class MviFragment : BaseReflectBindingViewModelToolbarFragment<CombaseFragmentMviBinding>() {

    /** ****************************** Properties ****************************** */

    /**  */
    companion object {
        val TAG: String = MviFragment::class.java.simpleName
    }

    private lateinit var mviViewModel: MviViewModel
    private var adapter = MviAdapter(arrayListOf())


    /** ****************************** Override ****************************** */

    /**  */
    override fun setupUi() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    binding.recyclerView.context,
                    (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }

        setupClicks()
    }

    /**  */
    override fun setupData() {
        binding.recyclerView.adapter = adapter
        // this.homepageVm.viewId.value = 0
    }

    /**  */
    override fun setToolbarTitle() {
        setToolbarTitle(R.string.combase_mvi_title)
    }

    /**  */
    override fun bindLifecycleOwner() {
        // binding.lifecycleOwner = viewLifecycleOwner
    }

    /**  */
    override fun bindXmlData() {
        // binding.homepageVm = homepageVm
        mviViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                // ApiHelperImpl(
                RetrofitBuilder.apiService
                // )
            )
        ).get(MviViewModel::class.java)
    }

    /**  */
    override fun observeViewModelData() {
        lifecycleScope.launch {
            mviViewModel.state.collect {
                when (it) {
                    is MviState.Idle -> {

                    }
                    is MviState.Loading -> {
                        binding.buttonFetchUser.visibility = View.GONE
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is MviState.Users -> {
                        binding.progressBar.visibility = View.GONE
                        binding.buttonFetchUser.visibility = View.GONE
                        renderList(it.user)
                    }
                    is MviState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(activity, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    /**  */
    override fun removeViewModelObserver() {
        // this.mviViewModel.viewId.removeObservers(viewLifecycleOwner)
    }

    /**  */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            // this.homepageVm.viewId.value = 0
        }
    }


    /** ****************************** Functions ****************************** */

    /**  */
    private fun setupClicks() {
        binding.buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mviViewModel.userIntent.send(MviIntent.FetchUser)
            }
        }
    }

    /**  */
    private fun renderList(users: List<User>) {
        binding.recyclerView.visibility = View.VISIBLE
        users.let { listOfUsers -> listOfUsers.let { adapter.addData(it) } }
        adapter.notifyDataSetChanged()
    }


    /** ****************************** Implementations ****************************** */

    /**  */
    private val vmObserverViewId = Observer<Int> { t ->
        when (t) {
        }
    }
}
