package com.fetchrewards.listing.activities

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.fetchrewards.listing.modal.Item

@Composable
fun ItemRow(item: Item) {
    Column {
        ListItem (
            headlineContent = {   Text(item.name,style=MaterialTheme.typography.bodyLarge .copy(
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            ), )
                },
            supportingContent = {
                Text("List Id: "+item.listId.toString(),)
            },
            leadingContent = {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = {  IconButton(onClick = { }) {
                Icon(Icons.Filled.MoreVert,modifier = Modifier.alpha(0.5f), contentDescription = "More options")
            } }
        )
        HorizontalDivider()
    }
}

