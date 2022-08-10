package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post

interface PostInterface {
    val data: MutableLiveData<Post>
    fun share()
    fun like()
}