package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.data.PostRepositoryImplementation
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.databinding.PostLayoutBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        var postRepository = PostRepositoryImplementation()
        var posts = postRepository.posts
        setContentView(binding.root)
        val adapter = PostAdapter() {
            viewModel::onLikeClicked
            viewModel::onShareClicked
        }
        var bindingPost = PostLayoutBinding.inflate(layoutInflater)

//        binding.postRecyclerView.adapter = adapter

        viewModel.data.observe(this) {
            adapter.posts = posts
        }

    }
}
