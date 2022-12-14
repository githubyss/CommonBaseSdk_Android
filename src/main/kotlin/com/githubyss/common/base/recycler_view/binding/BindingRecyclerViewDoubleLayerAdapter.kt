package com.githubyss.common.base.recycler_view.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.githubyss.common.base.BR


/**
 * BindingRecyclerViewDoubleLayerAdapter
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/04 15:08:15
 */
class BindingRecyclerViewDoubleLayerAdapter : RecyclerView.Adapter<BindingRecyclerViewDoubleLayerAdapter.BindingViewHolder>() {

    /** ****************************** Object ****************************** */

    /**  */
    companion object {
        val TAG: String = BindingRecyclerViewDoubleLayerAdapter::class.java.simpleName
    }


    /** ****************************** Properties ****************************** */

    /**  */
    private lateinit var items: List<BindingAdapterDoubleLayerItem>
    private lateinit var innerRecyclerViewAdapter: BindingRecyclerViewAdapter

    /**  */
    lateinit var onItemClickListener: OnItemClickListener
    lateinit var onInnerItemClickListener: BindingRecyclerViewAdapter.OnItemClickListener


    /** ****************************** Override ****************************** */

    /**
     * onCreateViewHolder(ViewGroup, Int) 方法负责将获取将 ViewHolder 取出。
     *
     * @param
     * @return RecyclerView.ViewHolder 的子类实例
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        // 通过 DataBindingUtil 的 inflate 方法获取一个 ViewDataBinding，包含了 Layout 中所有的控件。
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false)
        return BindingViewHolder(binding)
    }

    /**
     * onBindViewHolder(BindingHolder, Int) 负责将实体类的内容一条一条的通过 set 方法显示到对应的界面上。
     *
     * @param
     * @return
     */
    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.bindXmlData(items[position])
        holder.bindXmlClickListener(onItemClickListener)
        innerRecyclerViewAdapter = BindingRecyclerViewAdapter()
        innerRecyclerViewAdapter.updateDataList(items[position].innerItems)
        innerRecyclerViewAdapter.onItemClickListener = onInnerItemClickListener
        holder.bindXmlInnerRecyclerViewAdapter(innerRecyclerViewAdapter)
    }

    /**  */
    override fun getItemCount() = items.size

    /**  */
    override fun getItemViewType(position: Int): Int {
        return items[position].layoutId
    }

    /** ****************************** Functions ****************************** */

    /**  */
    fun updateDataList(items: List<BindingAdapterDoubleLayerItem>) {
        this.items = items
        notifyDataSetChanged()
    }


    /** ****************************** Class ****************************** */

    /**
     * BindingViewHolder
     * ViewHolder 用来通过 findViewById 来存放 item 对应的 layout 里边的 View 控件。
     *
     * @author Ace Yan
     * @github githubyss
     * @createdTime 2022/07/28 11:43:44
     */
    inner class BindingViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bindXmlData(item: BindingAdapterDoubleLayerItem) {
            binding.setVariable(BR.item, item)
        }

        fun bindXmlClickListener(onItemClickListener: OnItemClickListener) {
            binding.setVariable(BR.onItemClickListener, onItemClickListener)
        }

        fun bindXmlInnerRecyclerViewAdapter(innerRecyclerViewAdapter: BindingRecyclerViewAdapter) {
            binding.setVariable(BR.innerRecyclerViewAdapter, innerRecyclerViewAdapter)
        }
    }


    /** ****************************** Interface ****************************** */

    /**  */
    interface OnItemClickListener {
        fun onItemClick(data: BindingAdapterDoubleLayerItem)
    }
}
