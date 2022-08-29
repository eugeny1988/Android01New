package ru.netology.nmedia.data

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.Post

class PostViewModel : ViewModel() {
    private val repository: PostInterface = PostImplementation()
    val data by repository::data
    fun onLikeClicked(post: Post) = repository.like(post)
    fun onShareClicked(post: Post) = repository.share(post)
}