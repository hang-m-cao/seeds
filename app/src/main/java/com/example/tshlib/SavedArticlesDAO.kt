package com.example.tshlib
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SavedArticlesDAO {
    @Query("SELECT * FROM articles WHERE id == (:id)")
    fun getArticle(id: Int): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Delete
    fun deleteArticle(article:Article)

    @Query("SELECT * FROM articles")
    fun getArticles(): List<Article>
}