package aleksey.onlineshop.adapter

import aleksey.onlineshop.api.BASE_URL
import aleksey.onlineshop.databinding.CardShopBinding
import aleksey.onlineshop.dto.Price
import aleksey.onlineshop.dto.Shop
import aleksey.onlineshop.services.load
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


interface OnInteractionListener {
    fun sortToRating(rating: Price) {}
    fun sortWithDiscountMax(withDiscountMax: Price) {}
    fun sortWithDiscountMin(withDiscountMin: Price) {}
    fun onLike(shop: Shop) {}
    fun onCount(available: Shop) {}
    fun discount(discount: Price) {}
    fun add(subtitle: Shop) {}
}

class ShopsAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Shop, ShopViewHolder>(ShopDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = CardShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShopViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop = getItem(position)
        holder.bind(shop)
    }
}

class ShopViewHolder(
    private val binding: CardShopBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(shop: Shop) {
        binding.apply {
            product.load("${BASE_URL}/id")
            title.text = shop.title
            subtitle.text = shop.subtitle
            favorite.isChecked = shop.likedByMe
            favorite.setOnClickListener {
                onInteractionListener.onLike(shop)
            }
            priceCurrent.text = shop.price.toString()
            priceWithDiscount.text = shop.price.priceWithDiscount.toString()
            discount.text = shop.price.discount.toString()
            //available.text = "${shop.available}"
            discount.text = shop.price.discount.toString()
//            companyName.text = shop.info.titleArt
//            feedbackCount.text = shop.feedback.count
//            feedbackRating.text = shop.feedback.rating
//            tegs.text = shop.tags
//            characteristics.text = shop.description
//            article.text = shop.info.valueArt
//            tags.text = shop.info.valueUse
//            country.text = shop.info.valueCountry
//            compound.text = shop.ingredients

        }
    }
}

class ShopDiffCallback : DiffUtil.ItemCallback<Shop>() {
    override fun areItemsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Shop, newItem: Shop): Boolean {
        return oldItem == newItem
    }
}