package aleksey.onlineshop.repository

import aleksey.onlineshop.api.ShopApi
import aleksey.onlineshop.dao.ShopDao
import aleksey.onlineshop.entity.ShopEntity
import aleksey.onlineshop.entity.toDto
import aleksey.onlineshop.entity.toEntity
import aleksey.onlineshop.error.ApiError
import aleksey.onlineshop.error.NetworkError
import aleksey.onlineshop.error.UnknownError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.io.IOException

class ShopRepositoryImpl(private val dao: ShopDao) : ShopRepository {
    override val data = dao.getAll()
        .map(List<ShopEntity>::toDto)
        .flowOn(Dispatchers.Default)


    override suspend fun getAll() {
        try {
            val response = ShopApi.service.getAll()
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }

            val body = response.body() ?: throw ApiError(response.code(), response.message())
            dao.insert(body.toEntity())
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }

    override suspend fun likeById(id: Long) {
        TODO("Not yet implemented")
    }
}