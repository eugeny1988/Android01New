package ru.netology.nmedia.data

import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding


class PostImplementation() : PostInterface {
    private val binding = ActivityMainBinding.inflate(layoutInflater)
    override val layoutInflater: LayoutInflater
        get() = TODO("Not yet implemented")
    override val data = MutableLiveData(Post(
    1,
    "Нетология",
    "Какой-то текст",
    "03.08.2022",
    "0",
    "0"))
    override fun like() {
        val currentPost = data.value
        var likes = currentPost?.postLikes?.toInt()!!
        if (!currentPost.isLiked) {
            binding.imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
            likes++

        } else {
            binding.imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
            likes--
        }
        currentPost.postLikes = likes.toString()
        currentPost.isLiked = !currentPost.isLiked

    }
    override fun share(){
        val currentPost = data.value
        var shares = currentPost?.postShares?.toInt()!!
        val sharedPost = currentPost?.copy(postShares = shares++.toString())
        data.value = sharedPost
    }

}