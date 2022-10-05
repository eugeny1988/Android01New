package ru.netology.nmedia.data

import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post

class PostImplementation() : PostInterface {
    override var data = MutableLiveData<List<Post>>(
    )

    override fun share(post: Post) {

    }

    override fun like(post: Post) {

    }



}