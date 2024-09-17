package com.fetchrewards.listing.activities


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorMessage(onRetry: () -> Unit) {



    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Warning,
                contentDescription = "Error",
                tint = Color.Gray,
                modifier = Modifier
                    .size(80.dp)
            )
            Text(
                text = "Something went wrong :(",
                color = Color.Gray,
                fontSize = 18.sp
            )
            Button(
                onClick = { onRetry() },
                colors = ButtonDefaults.buttonColors(),
                shape = RoundedCornerShape(50),
            ) {
                Text("Try Again")
            }
        }
    }
}
