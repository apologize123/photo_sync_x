package com.example.photo_sync_x.component;

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.photo_sync_x.mNavController
import kotlin.toString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDirectComponent() {
    var title = ""
    var key = ""
    // 文件夹路径
    var list = ArrayList<String>()
    val folderPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri: Uri? ->
        list.add(uri.toString())
    }
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        IconButton(onClick = {
                            mNavController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = ""
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { folderPickerLauncher.launch(null) },
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                    )
                }
            }
        ) { padding ->
            Column(modifier = Modifier.padding(padding)) {
                for (item in list) {
                    ListItem(
                        headlineContent = {
                            Text(text = item)
                        },
                        trailingContent = {
                            IconButton(onClick = {
                                list.remove(item)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.DeleteOutline,
                                    contentDescription = ""
                                )
                            }
                        },
                        shadowElevation = 4.dp,
                    )
                }
            }
        }
    }
}

