package ru.netology.nmedia.data

import android.provider.Settings.Global.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.R

class PostImplementation() : PostInterface {
    override val data = MutableLiveData(Post(
    1,
    "Нетология",
    "Какой-то текст",
    "03.08.2022",
    0,
    0))
    override fun like() {
        val currentPost = data.value
        val likedPost = currentPost?.copy(isLiked = !currentPost.isLiked)
        data.value = likedPost
    }
}