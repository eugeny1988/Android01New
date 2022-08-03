package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.data.PostViewModel
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel = PostViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
val post = viewModel.data.value
        setContentView(binding.root)
        viewModel.data.observe(this) { post ->
            }

        imageViewLikes.setOnClickListener {
            let {
                viewModel.onLikeClicked()
            }
            imageViewShare.setOnClickListener {

                binding.textViewShares.setText(post?.viewClicks(post.postShares++))
                println("share")
            }
        }
        binding.root.setOnClickListener() {
            println("Я кликнул по экрану")
        }
        binding.netologyLogo.setOnClickListener {
            println("Клик по аватару")
        }

    }


}
