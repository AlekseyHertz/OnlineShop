package aleksey.onlineshop.viewmodel

import aleksey.onlineshop.db.AppDb
import aleksey.onlineshop.model.FeedModel
import aleksey.onlineshop.model.FeedModelState
import aleksey.onlineshop.repository.ShopRepository
import aleksey.onlineshop.repository.ShopRepositoryImpl
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ShopViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShopRepository =
        ShopRepositoryImpl(AppDb.getInstance(context = application).shopDao())

    val data: LiveData<FeedModel> = repository.data
        .map(::FeedModel)
        .asLiveData(Dispatchers.Default)

    private val _dataState = MutableLiveData<FeedModelState>()
    val dataState: LiveData<FeedModelState>
        get() = _dataState

    init {
        loadShops()
    }

    fun loadShops() = viewModelScope.launch {
        try {
            _dataState.value = FeedModelState(loading = true)
            repository.getAll()
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun likeById() = viewModelScope.launch {
        try {
            //repository.likeById(id)
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }

    fun sort() = viewModelScope.launch {
        try {
            //
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }
}