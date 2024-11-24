package com.example.photo_sync_x.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PhotosComponent(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Photos")
    }
}