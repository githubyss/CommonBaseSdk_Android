package com.githubyss.common.base.app.page.mvi

import com.githubyss.common.base.app.page.mvi.model.User


interface ApiHelper {
    suspend fun getUsers(): List<User>
}
