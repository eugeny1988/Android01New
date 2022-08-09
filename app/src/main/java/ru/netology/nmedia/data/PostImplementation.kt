package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post


class PostImplementation() : PostInterface {
    override val data = MutableLiveData<Post>(
    )

    override fun like(post: Post) {
        var likes = post.postLikes
        if (!post.isLiked) likes++ else likes--
        post.postLikes = likes
        post.isLiked = !post.isLiked
        data.value = post

    }

    override fun share(post: Post) {
        post.postShares++
        data.value = post
    }

}