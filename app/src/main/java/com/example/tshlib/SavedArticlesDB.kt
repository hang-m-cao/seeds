package com.example.tshlib
import android.content.Context
import androidx.room.*

@Database(entities = [Article::class], version = 1)
abstract class SavedArticlesDB : RoomDatabase() {
    abstract fun articleDAO(): SavedArticlesDAO

    companion object {
        @Volatile
        private var INSTANCE: SavedArticlesDB? = null

        fun getInstance(context: Context): SavedArticlesDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SavedArticlesDB::class.java,
                        "saved_articles_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}