package com.githubyss.common.base.app.page.mvi


class MviRepository(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}
