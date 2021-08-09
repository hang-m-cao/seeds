package com.example.tshlib

data class Article (
        val id: Int,
        val title: String,
        val image: String?,
        val link: String,
        val tag: String,
        val saved: Boolean = false
)