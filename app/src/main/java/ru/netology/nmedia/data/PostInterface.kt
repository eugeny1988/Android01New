package ru.netology.nmedia.data

import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostInterface {
    val data: LiveData<Post>
    fun share(post: Post)
    fun like(post: Post)
}