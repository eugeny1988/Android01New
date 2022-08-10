package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post


class PostImplementation() : PostInterface {
    override val data: MutableLiveData<Post> = MutableLiveData<Post>(
        Post(
            1,
            "Нетология",
            "Какой-то текст",
            "10.08.2022",
            0,
            0
        )
    )

    override fun like() {
        var post = data.value
        var likes = post?.postLikes!!
        if (!post?.isLiked!!) likes++ else likes--
        post.postLikes = likes
        post.isLiked = !post.isLiked
        data.value = post!!

    }

    override fun share() {
        var shares = data.value?.postShares!!
        shares++
        data.value?.postShares = shares
    }

}