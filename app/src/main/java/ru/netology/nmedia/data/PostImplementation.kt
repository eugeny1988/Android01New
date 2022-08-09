package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post


class PostImplementation() : PostInterface {
    override val data = MutableLiveData<Post>(
//        Post(
//            1,
//            "Нетология",
//            "Какой-то текст",
//            "03.08.2022",
//            "0",
//            "0"
//        )
    )

    override fun like(post: Post) {
        var likes = post.postLikes.toInt()
        if (!post.isLiked) likes++ else likes--
        post.postLikes = likes.toString()
        post.isLiked = !post.isLiked
        data.value = post

    }

    override fun share(post: Post) {
        var shares = post.postShares.toInt()
        val post = post.copy(postShares = shares++.toString())
        data.value = post
    }

}