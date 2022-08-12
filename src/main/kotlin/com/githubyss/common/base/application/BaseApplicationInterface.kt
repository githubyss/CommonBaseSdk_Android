package com.githubyss.common.base.application


/**
 * BaseApplicationInterface
 *
 * @author Ace Yan
 * @github githubyss
 * @createdTime 2022/08/11 16:01:25
 */
interface BaseApplicationInterface {
    /**  */
    open fun initComkit() {}

    /**  */
    open fun initComnet() {}

    /**  */
    open fun initLog() {}

    /**  */
    open fun initARouter() {}

    /**  */
    open fun initTrace() {}
}
