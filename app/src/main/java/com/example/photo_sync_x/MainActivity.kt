package com.example.photo_sync_x

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photo_sync_x.ui.theme.Photo_sync_xTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { },
                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Settings"
                                    )
                                }
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Settings"
                                    )
                                }
                            },
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Sync,
                                contentDescription = "Settings"
                            )
                        }
                    },
                    bottomBar = {
                        NavigationBar() {
                            NavigationBarItem(
                                selected = true,
                                onClick = { },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.TaskAlt,
                                        contentDescription = ""
                                    )
                                },
                                label = { Text("任务") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = { },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Settings,
                                        contentDescription = "Settings"
                                    )
                                },
                                label = { Text("设置") }
                            )
                        }
                    }
                ) { innerPadding ->
                    TaskListComponent(modifier = Modifier.padding(innerPadding))
//                    TaskInfoComponent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Photo_sync_xTheme {
        Greeting("Android")
    }
}

data class TaskModel(
    val name: String,
    val description1: String,
    val description2: String,
    val status: Boolean,
    val time: String
)

@Composable
@Preview
fun TaskListComponentPreview() {
}

@Composable
fun TaskListComponent(modifier: Modifier) {
    var list by remember { mutableStateOf(listOf<TaskModel>()) }
    list = listOf(
        TaskModel(
            name = "任务1",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-01"
        ),
        TaskModel(
            name = "任务2",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-02"
        ),
        TaskModel(
            name = "任务3",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-03"
        ), TaskModel(
            name = "任务1",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-01"
        ),
        TaskModel(
            name = "任务2",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-02"
        ),
        TaskModel(
            name = "任务3",
            description1 = "描述1",
            description2 = "描述2",
            status = true,
            time = "2021-01-03"
        )
    )
    LazyColumn(modifier = modifier) {
        items(list.size) { item ->
            TaskItem(list[item])
        }
    }
}

@Composable
fun TaskItem(taskModel: TaskModel) {
    var isOpen by remember { mutableStateOf(false) }
    ListItem(
        modifier = Modifier.clickable(onClick = { isOpen = !isOpen }),
        headlineContent = { Text(text = taskModel.name) },
        supportingContent = {
            Column {
                Text(text = taskModel.description1, fontSize = 10.sp)
                Text(text = taskModel.description2, fontSize = 10.sp)
            }
        },
        trailingContent = {
            Switch(
                checked = taskModel.status,
                onCheckedChange = {},
                enabled = true,
            )
        },
    )
    if (isOpen) {
        Column(modifier = Modifier.padding(start = 32.dp)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text("源") },
                shape = RoundedCornerShape(18.dp),
                value = "",
                onValueChange = {},
                enabled = false,
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Folder,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                label = { Text("目标") },
                value = "",
                onValueChange = {},
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                label = { Text("模式") },
                value = "",
                enabled = false,
                onValueChange = {},
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                label = { Text("频率") },
                value = "",
                enabled = false,
                onValueChange = {},
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    }
    HorizontalDivider()
}

@Composable
@Preview
fun TaskInfoComponentPreview() {
    TaskInfoComponent(modifier = Modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskInfoComponent(modifier: Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Button(onClick = { showDialog = true }) {
            Text(text = "添加任务")
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
//                showDialog = false
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Column(modifier = modifier) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("源") },
                        shape = RoundedCornerShape(18.dp),
                        value = "",
                        onValueChange = {},
                        enabled = false,
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.Folder,
                                    contentDescription = "Settings"
                                )
                            }
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        label = { Text("目标") },
                        value = "",
                        onValueChange = {},
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        label = { Text("模式") },
                        value = "",
                        enabled = false,
                        onValueChange = {},
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Settings"
                                )
                            }
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        label = { Text("频率") },
                        value = "",
                        enabled = false,
                        onValueChange = {},
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Settings"
                                )
                            }
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("取消")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("保存")
                }
            }
        )
    }


}