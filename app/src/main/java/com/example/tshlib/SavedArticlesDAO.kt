package com.example.tshlib
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SavedArticlesDAO {
    @Query("SELECT * FROM saved_articles WHERE id == (:id)")
    fun getArticle(id: Int): List<SavedArticles>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: SavedArticles)

    @Delete
    fun deleteArticle(article: SavedArticles)
}