package com.fetchrewards.listing.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.fetchrewards.listing.api.ItemRepository
import com.fetchrewards.listing.modal.Item


class ItemViewModel : ViewModel() {

    private val repository = ItemRepository()

    private val _items = mutableStateOf<List<Item>>(emptyList())
    private val _isLoading= mutableStateOf<Boolean>(true)
    private val _error=mutableStateOf<Boolean>(false)

    val isLoading= _isLoading
    val items: State<List<Item>> = _items
    val error=_error

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            _isLoading.value=true
            _error.value=false
            try {
                val result = repository.fetchItems()
                _items.value = result
            }catch (e: Exception){
                _error.value= true
            }finally {
                _isLoading.value=false
            }
        }
    }


}
