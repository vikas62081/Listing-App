package com.fetchrewards.listing.api

import com.fetchrewards.listing.modal.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ItemRepository {

    private fun sortItemsByNumericName(items: List<Item>): List<Item> {
        return items.sortedWith(
            compareBy<Item> { it.listId } // First, sort by listId
                .thenBy { extractNumber(it.name)  } // Then, sort by the numeric value in name
        )
    }

    private fun extractNumber(name: String): Int {
        return name.filter { it.isDigit() }.toIntOrNull() ?: 0
    }

    suspend fun fetchItems(): List<Item> {
        return withContext(Dispatchers.IO) {
            val items = RetrofitInstance.api.getItems()

            val filteredItems = items.filter { !it.name.isNullOrBlank() }
            val sortedItems = sortItemsByNumericName(filteredItems)

            sortedItems
        }
    }

}

