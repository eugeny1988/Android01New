package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.Post
import ru.netology.nmedia.PostAdapter
import ru.netology.nmedia.data.*
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostAdapter {
            viewModel.onLikeClicked(it)
        }
        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.posts = posts as MutableList<Post>
        }
    }
}