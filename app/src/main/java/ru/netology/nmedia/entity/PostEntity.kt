package ru.netology.nmedia.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.nmedia.Post
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    val likes: Int = 0,
    val shares: Int,
    val views: Int,
    val videoUrl: String?,
) {
    //fun toDto() = Post(id, author, content, published, likedByMe, likes, shares, views, videoUrl)

    companion object {
        private val sdf: DateFormat = SimpleDateFormat.getDateTimeInstance()

        fun fromDto(dto: Post) =
            PostEntity(dto.id, "Me", dto.content, sdf.format(Date()), dto.likedByMe, dto.likes, dto.shares, dto.views, dto.videoUrl)

    }
}
