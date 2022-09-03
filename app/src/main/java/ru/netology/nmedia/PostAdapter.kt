package ru.netology.nmedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.data.PostRepositoryImplementation
import ru.netology.nmedia.databinding.PostLayoutBinding

internal class PostAdapter(
    private val posts: List<Post>,
    private val onLikeClicked: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: PostLayoutBinding,
        private val onLikeClicked: (Post) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        val postRepository = PostRepositoryImplementation()
        fun bind(post: Post) = with(binding) {
            this.name.setText(post.author)
            this.date.setText(post.published)
            this.textViewLikes.setText(
                post.viewNumbers(
                    post.postLikes
                )
            )
            this.textViewShares.setText(
                post.viewNumbers(
                    post.postShares
                )
            )
            this.textViewMessage.setText(post.content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = PostLayoutBinding.inflate(inflator, parent, false)
        return ViewHolder(binding) {
            onLikeClicked(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount() = posts.size


}