package ru.netology.nmedia.repository

import androidx.lifecycle.Transformations
import ru.netology.nmedia.Post
import ru.netology.nmedia.dao.PostDao
import ru.netology.nmedia.entity.PostEntity

class PostRepositoryImpl(
    private val dao: PostDao,
) : PostRepository {
    override fun getAll() = Transformations.map(dao.getAll()) { list ->
        list.map {
            Post(it.id, it.author, it.content, it.published, it.likedByMe, it.likes, it.views, it.shares, it.videoUrl)
        }
    }

    override fun likeById(id: Long) {
        dao.likeById(id)
    }

    override fun shared(id: Long) {
        dao.shared(id)
    }

    override fun viewed(id: Long) {
        dao.viewed(id)
    }

    override fun save(post: Post) {
        dao.save(PostEntity.fromDto(post))
    }

    override fun video(post: Post) {
        post.videoUrl?.let { dao.video(it) }
    }

    override fun removeById(id: Long) {
        dao.removeById(id)
    }
}