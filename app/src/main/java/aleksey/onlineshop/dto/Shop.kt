package aleksey.onlineshop.dto

data class Shop (
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
)

data class Price (
    val price: Int,
    val discount: Int,
    val priceWithDiscount: Int,
    val unit: String
)

data class Feedback (
    val count: Double,
    val rating: Double
)

data class Info (
    val titleArt: String,
    val valueArt: Int,
    val titleUse: String,
    val valueUse: String,
    val titleCountry: String,
    val valueCountry: String
)

fun convertCount(element: Int) =
    when (element) {
        in 0..999 -> element.toString()
        in 1_000..99_999 -> String.format("%.1fK", (element / 100 * 100).toDouble() / 1000)
        in 100_000..999_999 -> "${element / 1_000}K"
        else -> String.format("%.1fM", (element / 100_000 * 100_000).toDouble() / 1_000_000)
    }

/* data class Shop(
    val id: Int,
    val shared: Boolean = false, // Кнопка “Поделиться”. Нефункциональный элемент. При клике на эту кнопку ничего не происходит.
    val likes: Boolean = false,
    val attachment: Attachment? = null,
    val image: Int,
    val information: String,
    val title: String, //
    val subtitle: String,
    val available: Int,
    val feedback: Feedback? = null,
    val price: Price? = null,
    val content: String = "Description Product",
    val description: String,
    val show: ArrayList<Info>,
)

class Info (
    val titleInfo: String,

){

}

data class Attachment(
    val uri: String,
    val type: AttachmentType,
)

enum class AttachmentType {
    IMAGE
}

data class Feedback(
    val ratingShow: Int,
    val ratingInt: Int,
    val ratingCount: Int
)

data class Price(
    val rating: Long,
    val withDiscountMax: Long,
    val withDiscountMin: Long,
    val unit: Boolean,
    val price: Int,
    val discount: Int,
)


fun convertCount(element: Int) =
    when (element) {
        in 0..999 -> element.toString()
        in 1_000..99_999 -> String.format("%.1fK", (element / 100 * 100).toDouble() / 1000)
        in 100_000..999_999 -> "${element / 1_000}K"
        else -> String.format("%.1fM", (element / 100_000 * 100_000).toDouble() / 1_000_000)
    }
    */