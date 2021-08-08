package com.example.tshlib

data class Article (
        val id: Int,
        val title: String?,
        val image: String? = "http://cliparts.co/cliparts/yTk/85p/yTk85p8TE.jpg",
        val link: String?,
        val tag: String?,
        val saved: Boolean = false
)