package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostRepository {
    var data: LiveData<List<Post>>
    fun like(post: Post)
    fun share(post: Post)
}