package ru.netology.nmedia.data

import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {
    private val repository: PostInterface = PostImplementation()
    val data by repository::data
    fun onLikeClicked() = repository.like()
}