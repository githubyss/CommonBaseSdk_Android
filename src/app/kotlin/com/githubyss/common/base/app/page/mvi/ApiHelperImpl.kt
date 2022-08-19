package com.githubyss.common.base.app.page.mvi

import com.githubyss.common.base.app.page.mvi.model.User


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}
