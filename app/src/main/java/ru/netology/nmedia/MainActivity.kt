package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
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

        var likes = post.postLikes.toInt()
        var shares = post.postShares.toInt()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageViewLikes.setOnClickListener {
            let {
                if (!post.isLiked) {
                    binding.imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
                    post.isLiked = true
                    likes++
                    binding.textViewLikes.setText(post.viewClicks(likes))
                } else {
                    binding.imageViewLikes.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
                    likes--
                    post.isLiked = false
                    binding.textViewLikes.setText(post.viewClicks(likes))
                }
            }

        }
        imageViewShare.setOnClickListener{
            binding.textViewShares.setText(post.viewClicks(shares++))
        }

    }



    }
