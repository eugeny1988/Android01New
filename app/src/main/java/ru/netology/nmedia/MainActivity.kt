package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()
    private val binding = ActivityMainBinding.inflate(layoutInflater)
    private var post = Post(
        1,
        getString(R.string.netologyName),
        getString(R.string.message),
        getString(R.string.date),
        getString(R.string.likes),
        getString(R.string.shares)

    )
    private var shares = post.postShares.toInt()
    private var likes = post.postLikes.toInt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        imageViewLikes.setOnClickListener {
            viewModel.onLikeClicked()

        }
        imageViewShare.setOnClickListener {
            viewModel.onShareClicked()
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
