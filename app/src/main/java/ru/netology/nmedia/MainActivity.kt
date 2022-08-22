package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.post_layout.*
import ru.netology.nmedia.data.PostImplementation
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
        postRepository.posts.map { post ->
            PostLayoutBinding.inflate(layoutInflater)
        }

        imageViewLikes.setOnClickListener {
            viewModel.onLikeClicked()
        }
        imageViewShare.setOnClickListener {
            viewModel.onShareClicked()

        }
        viewModel.data.observe(this) {
            if (it[index].isLiked) imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
            else
                imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
            binding.name.setText(it[index].author)
            binding.date.setText(it[index].published)
            binding.textViewLikes.setText(it[index].viewNumbers(it[index].postLikes))
            binding.textViewShares.setText(it[index].viewNumbers(it[index].postShares))
            binding.textViewMessage.setText(it[index].content)
        }

    }


}
