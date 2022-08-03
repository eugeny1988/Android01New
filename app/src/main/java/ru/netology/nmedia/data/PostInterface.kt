package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostInterface {
    val data: LiveData<Post>
    fun like()
}