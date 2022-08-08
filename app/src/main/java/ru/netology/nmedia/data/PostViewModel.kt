package ru.netology.nmedia.data

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.Post
import ru.netology.nmedia.databinding.ActivityMainBinding

class PostViewModel : ViewModel() {
    private val repository: PostInterface = PostImplementation()
    val data by repository::data
    fun onLikeClicked(post : Post) = repository.like(post)
    fun onShareClicked(post: Post) = repository.share(post)
}