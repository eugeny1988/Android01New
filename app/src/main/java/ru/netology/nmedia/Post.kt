package ru.netology.nmedia

import kotlin.math.round

data class Post(
    var id: Long,
    var author: String,
    var content: String,
    var published: String,
    var postLikes: Int,
    var postShares: Int,
    var isLiked: Boolean = false
) {
    fun viewNumbers(count: Int): String {
        return when (count) {
            in 0..1099 -> "$count"
            in 1100..10_000 -> "${round((count / 100).toDouble()) / 10}K"
            in 10_001..999_999 -> "${round((count / 1000).toDouble())}K"
            else -> "${round((count / 100_000).toDouble()) / 10}M"
        }
    }
}
