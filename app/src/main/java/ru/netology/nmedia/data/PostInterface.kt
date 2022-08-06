package ru.netology.nmedia.data

import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostInterface {
    abstract val layoutInflater: LayoutInflater
    val data: LiveData<Post>
    fun like()
    fun share()
}