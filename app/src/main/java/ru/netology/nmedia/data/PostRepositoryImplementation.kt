package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post

class PostRepositoryImplementation : PostRepository {

    override var data: LiveData<List<Post>> = MutableLiveData<List<Post>>()
    var posts = checkNotNull(mutableListOf<Post>())
    init {
        repeat(10) {
            posts.add(
                Post(
                    it,
                    "Евгений",
                    "Пост номер $it",
                    "18.08.2022",
                    0,
                    0
                )
            )
            data = MutableLiveData(posts)
        }
    }

    override fun like(post: Post) {
        post.isLiked = !post.isLiked
        post.postLikes++
    }
    override fun share(post: Post) {
        var shares = post.postShares
        shares++
        post.postShares = shares
    }
}