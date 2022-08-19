package com.githubyss.common.base.app.page.mvi


sealed class MviIntent {
    object FetchUser : MviIntent()
}
