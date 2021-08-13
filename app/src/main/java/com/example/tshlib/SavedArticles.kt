package com.example.tshlib
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_articles")
data class SavedArticles(
    @PrimaryKey
    var id: Int
)