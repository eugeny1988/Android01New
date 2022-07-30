package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val content: String,
//    val published: String,
    var postLikes: String,
    var postShares: String,
    var isLiked: Boolean = false,
)
