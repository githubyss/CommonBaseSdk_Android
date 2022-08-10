package com.githubyss.common.base.recycler_view.binding


/**
 * BindingAdapterDoubleLayerItem
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/04 15:38:30
 */
interface BindingAdapterDoubleLayerItem : BindingAdapterItem {
    val innerItems: List<BindingAdapterItem>
}
