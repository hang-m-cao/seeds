package com.example.tshlib
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
        @PrimaryKey
        var id: Int,
        val title: String,
        val image: String?,
        val link: String,
        val tag: String
)