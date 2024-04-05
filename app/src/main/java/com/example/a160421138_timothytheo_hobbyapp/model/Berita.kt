package com.example.a160421138_timothytheo_hobbyapp.model

data class Berita(
    val id:Int?,
    val username: String?,
    val title: String?,
    val description: String?,
    val photo_url: String?,
    val article: List<Article>
)

data class Article(
    val subtitle: String?,
    val paragraph: String?
)