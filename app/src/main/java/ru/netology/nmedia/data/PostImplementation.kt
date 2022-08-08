package ru.netology.nmedia.data
import ru.netology.nmedia.MainActivity
import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import android.app.Activity
import android.provider.Settings.Global.getString


class PostImplementation() : PostInterface {
    override val data = MutableLiveData(
        Post(
            1,
            "Нетология",
            "Какой-то текст",
            "03.08.2022",
            "0",
            "0"
        )
    )
    override fun like(post: Post) {
        var likes = post.postLikes.toInt()
        if (!post.isLiked) likes++ else likes--
        post.postLikes = likes.toString()
        post.isLiked = !post.isLiked
        data.value = post

    }
    override fun share(post: Post){
        val currentPost = data.value
        var shares = post.postShares.toInt()
        val sharedPost = post.copy(postShares = shares++.toString())
        data.value = post
    }

}