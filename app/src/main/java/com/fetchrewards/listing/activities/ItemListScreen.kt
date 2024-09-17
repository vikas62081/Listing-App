package com.fetchrewards.listing.activities


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fetchrewards.listing.api.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel = viewModel()) {
    val itemList by viewModel.items
    val isLoading by viewModel.isLoading
    val error by viewModel.error

    Scaffold (
        topBar = { TopAppBar(title = "Listing App") }
    ) { paddingValues ->
        if (isLoading) {
            Loader()
        } else if(error){
            ErrorMessage(onRetry = {viewModel.fetchItems() })
        }else {
            ItemList(itemList,paddingValues)
        }
    }
}




