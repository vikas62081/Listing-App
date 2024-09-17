package com.fetchrewards.listing.activities

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fetchrewards.listing.modal.Item

@Composable
fun ItemList(itemList:List<Item>,paddingValues: PaddingValues){
    LazyColumn(
        contentPadding = paddingValues
    ) {
        itemList.groupBy { it.listId }
            .toList()
            .forEach { (listId, items) ->
                item {
                    Text(
                        text = "List ID: $listId",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(items) { item ->
                    ItemRow(item)
                }
            }
    }
}