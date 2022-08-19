package com.githubyss.common.base.app.page.mvi

import com.githubyss.common.base.app.page.mvi.model.User
import retrofit2.http.GET


interface ApiService {
    @GET("users?page=2")
    suspend fun getUsers(): List<User>
}
