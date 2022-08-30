package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.data.PostRepositoryImplementation
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()
    private val index = 1
    private val post = Post(
        index,
        getString(R.string.netologyName),
        "Пост №${index}",
        getString(R.string.date),
        getString(R.string.likes).toInt(),
        getString(R.string.shares).toInt()
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        var postRepository = PostRepositoryImplementation()
        setContentView(binding.root)

        viewModel.data.observe(this) {
            val adapter = PostAdapter(postRepository.posts) {
                viewModel.onLikeClicked(it)
            }
            binding.postRecyclerView.adapter = adapter
        }

    }
}
