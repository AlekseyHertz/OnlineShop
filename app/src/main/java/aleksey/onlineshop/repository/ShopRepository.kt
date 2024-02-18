package aleksey.onlineshop.repository

import aleksey.onlineshop.dto.Shop
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    val data: Flow<List<Shop>>
    suspend fun getAll()
    suspend fun likeById(id: Long)
}