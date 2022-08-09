package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var post = Post(
            1,
            getString(R.string.netologyName),
            getString(R.string.message),
            getString(R.string.date),
            getString(R.string.likes),
            getString(R.string.shares)

        )
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        imageViewLikes.setOnClickListener {
            viewModel.onLikeClicked(post)
            if (post.isLiked) imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
            else
                imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
            post.viewNumbers(post.postLikes.toInt())

        }
        imageViewShare.setOnClickListener {
            viewModel.onShareClicked(post)
            post.viewNumbers(post.postShares.toInt())

        }
        viewModel.data.observe(this) {
            binding.name.setText(it.author)
            binding.date.setText(it.published)
            binding.textViewLikes.setText(it.postLikes)
            binding.textViewShares.setText(it.postShares)
            binding.textViewMessage.setText(it.content)
        }

    }


}
