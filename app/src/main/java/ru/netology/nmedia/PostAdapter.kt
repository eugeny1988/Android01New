package ru.netology.nmedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.*
import ru.netology.nmedia.data.*
import ru.netology.nmedia.databinding.PostLayoutBinding

class PostAdapter(
    private val posts: List<Post>,
    private val onLikeClicked: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: PostLayoutBinding,
        private val onLikeClicked: (Post) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        val postRepository = PostRepositoryImplementation()
        fun bind(post: Post) = with(binding) {
            binding.container.name.setText(post.author)
            binding.container.date.setText(post.published)
            binding.container.textViewLikes.setText(
                post.viewNumbers(
                    post.postLikes
                )
            )
            binding.container.textViewShares.setText(
                post.viewNumbers(
                    post.postShares
                )
            )
            binding.container.textViewMessage.setText(post.content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = PostLayoutBinding.inflate(inflator, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount() = posts.size


}