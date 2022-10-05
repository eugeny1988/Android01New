package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post

interface PostInterface {
    val data: MutableLiveData<List<Post>>
    fun share(post: Post)
    fun like(post: Post)
}