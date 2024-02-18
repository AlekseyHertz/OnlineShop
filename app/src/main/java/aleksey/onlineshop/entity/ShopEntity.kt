package aleksey.onlineshop.entity

import aleksey.onlineshop.dto.Feedback
import aleksey.onlineshop.dto.Info
import aleksey.onlineshop.dto.Price
import aleksey.onlineshop.dto.Shop
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val subtitle: String,
    val likedByMe: Boolean,
    val price: Price,
    val feedback: Feedback,
    val tags: String,
    val available: Int,
    val description: String,
    val info: Info,
    val ingredients: String,
) {
    fun toDto() = Shop(
        id,
        title,
        subtitle,
        likedByMe,
        price,
        feedback,
        tags,
        available,
        description,
        info,
        ingredients,
    )

    companion object {
        fun fromDto(dto: Shop) = ShopEntity(
            dto.id,
            dto.title,
            dto.subtitle,
            dto.likedByMe,
            price = dto.price,
            dto.feedback,
            dto.tags,
            dto.available,
            dto.description,
            info = dto.info,
            dto.ingredients
        )
    }
}
fun List<ShopEntity>.toDto(): List<Shop> = map(ShopEntity::toDto)
fun List<Shop>.toEntity(): List<ShopEntity> = map(ShopEntity::fromDto)