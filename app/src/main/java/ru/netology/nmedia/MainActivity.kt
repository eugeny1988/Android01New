package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isClicked = false
        var likes = R.string.likes
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageView.setOnClickListener {
            let {
                if (!isClicked) {
                    binding.imageView.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
                    isClicked = true
                    likes++
                    textViewLikes.setText(likes.toString())
                } else {
                    binding.imageView.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)
                    likes--
                    textViewLikes.setText(likes.toString())
                }
            }


        }

        textViewLikes.setText(likes++)


    }
}
