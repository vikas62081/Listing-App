package com.fetchrewards.listing.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Loader(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().systemBarsPadding()
    ) {
        CircularProgressIndicator()
    }
}