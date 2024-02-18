package aleksey.onlineshop.model

import aleksey.onlineshop.dto.Shop

data class FeedModel(
    val shops: List<Shop> = emptyList(),
    val empty: Boolean = false,
)