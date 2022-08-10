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

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        imageViewLikes.setOnClickListener {
            viewModel.onLikeClicked()


        }
        imageViewShare.setOnClickListener {
            viewModel.onShareClicked()

        }
        viewModel.data.observe(this) {
            if (it.isLiked) imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
            else
                imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
            binding.name.setText(it.author)
            binding.date.setText(it.published)
            binding.textViewLikes.setText(it.viewNumbers(it.postLikes))
            binding.textViewShares.setText(it.viewNumbers(it.postShares))
            binding.textViewMessage.setText(it.content)
        }

    }


}
