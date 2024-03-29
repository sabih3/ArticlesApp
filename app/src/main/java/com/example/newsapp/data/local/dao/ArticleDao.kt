package com.example.newsapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.domain.dto.db.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM favorites WHERE id = :id")
    suspend fun getFavoriteById(id: Long): Article

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): LiveData<List<Article>>
}