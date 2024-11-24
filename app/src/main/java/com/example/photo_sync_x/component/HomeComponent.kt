package com.example.photo_sync_x.component;

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HomeComponent() {
    data class Item(val title: String, val icon: ImageVector)

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var currentIndex by remember { mutableStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerComponent()
            }
        },
    ) {
        Scaffold(topBar = {
            HomeTopBar()
        }, bottomBar = {
            val items = listOf(
                Item("Home", Icons.Default.Home),
                Item("Search", Icons.Default.Search),
                Item("Setting", Icons.Default.Settings),
            )
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = currentIndex == index,
                        onClick = { currentIndex = index },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                        label = { Text(item.title) }
                    )
                }
            }
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                content = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )
        }, content = { contentPadding ->
            if (currentIndex == 0) {
                PhotosComponent(modifier = Modifier.padding(contentPadding))
            } else if (currentIndex == 1) {
                SearchComponent(modifier = Modifier.padding(contentPadding))
            } else {
                SettingComponent(modifier = Modifier.padding(contentPadding))
            }
        })
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(title = { Text(text = "Photo Sync X") }, actions = {}, navigationIcon = {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back"
            )
        }
    })
}