package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import kotlinx.android.synthetic.main.post_layout.view.*
import ru.netology.nmedia.data.PostRepositoryImplementation
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.databinding.PostLayoutBinding

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
        binding.container
        var postRepository = PostRepositoryImplementation()
        setContentView(binding.root)

        viewModel.data.observe(this) {
            postRepository.posts.forEach { post ->
                PostLayoutBinding.inflate(layoutInflater, binding.container, true)
                    .apply {
                        binding.container.name.setText(postRepository.posts[index].author)
                        binding.container.date.setText(postRepository.posts[index].published)
                        binding.container.textViewLikes.setText(
                            postRepository.posts[index].viewNumbers(
                                postRepository.posts[index].postLikes
                            ).toString()
                        )
                        binding.container.textViewShares.setText(
                            postRepository.posts[index].viewNumbers(
                                postRepository.posts[index].postShares
                            ).toString()
                        )
                        binding.container.textViewMessage.setText(postRepository.posts[index].content)
                        imageViewLikes.setOnClickListener {
                            viewModel.onLikeClicked(post)
                        }
                        imageViewShare.setOnClickListener {
                            viewModel.onShareClicked(post)
                            if (postRepository.posts[index].isLiked) imageViewLikes.setImageResource(
                                R.drawable.ic_baseline_thumb_up_alt_24
                            )
                            else
                                imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)

                        }
                    }
                    .root
            }

        }
    }

}
