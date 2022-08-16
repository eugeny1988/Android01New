package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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
    val posts = mutableListOf(post)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        posts.map {
            posts.add(
                Post(
                    index + 1,
                    post.author,
                    "Пост №${index + 1}",
                    post.published,
                    post.postLikes,
                    post.postShares
                )
            )
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
