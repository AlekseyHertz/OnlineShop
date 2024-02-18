package aleksey.onlineshop.activity

import aleksey.onlineshop.adapter.OnInteractionListener
import aleksey.onlineshop.adapter.ShopsAdapter
import aleksey.onlineshop.databinding.FragmentItemCatalogBinding
import aleksey.onlineshop.dto.Price
import aleksey.onlineshop.dto.Shop
import aleksey.onlineshop.viewmodel.ShopViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FeedFragment : Fragment() {
    private val viewModel: ShopViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savesInstanceState: Bundle?
    ): View {
        val binding = FragmentItemCatalogBinding.inflate(inflater, container, false)

        val adapter = ShopsAdapter(object : OnInteractionListener {
            override fun onLike(shop: Shop) {
                viewModel.likeById()
            }

            override fun sortToRating(rating: Price) {
                viewModel.sort()
            }
        })


        return binding.root
    }
}