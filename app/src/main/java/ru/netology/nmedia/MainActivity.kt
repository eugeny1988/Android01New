package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isClicked = false
        var likes = R.string.likes
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView.setOnClickListener {
            let {
                if (!isClicked) {
                    binding.imageView.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
                    isClicked = true
                    likes++
                    binding.textViewLikes.setText(viewClicks(likes))
                } else {
                    binding.imageView.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
                    likes--
                    isClicked = false
                    binding.textViewLikes.setText(viewClicks(likes))
                }
            }


        }
    }


    fun viewClicks(likes: Int): String {
        return when (likes) {
            in 0..1099 -> likes.toString()
            in 1100..10_000 -> "${round((likes / 100).toDouble()) / 10}K"
            in 10_001..999_999 -> "${round((likes / 1000).toDouble()) / 10}K"
            else -> "${round((likes / 100_000).toDouble()) / 10}M"
        }
    }
}
