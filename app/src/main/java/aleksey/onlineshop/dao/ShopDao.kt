package aleksey.onlineshop.dao

import aleksey.onlineshop.entity.ShopEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {

    @Query("SELECT * FROM ShopEntity ORDER BY id DESC")
    fun getAll(): Flow<List<ShopEntity>>

    @Query("SELECT COUNT(*) == 0 FROM ShopEntity")
    suspend fun isEmpty(): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(posts: List<ShopEntity>)
}