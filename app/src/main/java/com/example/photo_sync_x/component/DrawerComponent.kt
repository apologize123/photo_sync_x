package com.example.photo_sync_x.component;

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.SettingsBackupRestore
import androidx.compose.material.icons.filled.SettingsRemote
import androidx.compose.material.icons.filled.SyncLock
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photo_sync_x.mNavController

@Composable
fun DrawerComponent() {

//    val list = listOf(
//        ItemData("显示上传通知", Icons.Default.NotificationsNone, "相册"),
//        ItemData("备份后删除文件", Icons.Default.DeleteOutline, "设置"),
//        ItemData("同时删除服务器文件", Icons.Default.DesignServices, "设置"),
//        ItemData("WI-FI 发现自动同步", Icons.Default.Wifi, "服务"),
//        ItemData("优先以服务器文件为主", Icons.Default.Phonelink, "设置"),
//        ItemData("只有在充电时才进行自动同步", Icons.Default.BatteryChargingFull, "设置"),
//        ItemData("自动从服务器下载文件至手机", Icons.Default.SettingsRemote, "设置"),
//    )
    var deviceDialog by remember { mutableStateOf(false) }
    var serviceDialog by remember { mutableStateOf(false) }
    var context = LocalContext.current
    if (deviceDialog) {
        DrawerAlertDialog(
            title = "设备名称",
            onDismissRequest = { deviceDialog = false },
            textFileValue = "123456",
            success = { value ->
                println("修改后::: -> $value")
            }
        )
    }
    if (serviceDialog) {
        DrawerAlertDialog(
            title = "服务器地址",
            onDismissRequest = { serviceDialog = false },
            textFileValue = "192.168.1.1",
            success = { value ->
                println("修改后::: -> $value")
            }
        )
    }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ListItem(
            modifier = Modifier.clickable(onClick = {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT)
            }),
            headlineContent = { Text("设备名称", fontSize = 14.sp) },
            supportingContent = { Text("192.168.1.1", fontSize = 10.sp) },
            leadingContent = {
                Icon(
                    Icons.Default.PhoneIphone,
                    contentDescription = "Home"
                )
            },
            shadowElevation = 4.dp,
        )
        ListItem(
            modifier = Modifier.clickable(onClick = {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT)
            }),
            headlineContent = { Text("服务器设置", fontSize = 14.sp) },
            supportingContent = { Text("192.168.1.1", fontSize = 10.sp) },
            leadingContent = {
                Icon(
                    Icons.Default.SettingsRemote,
                    contentDescription = "Home"
                )
            },
            shadowElevation = 4.dp,
        )
        ListItem(
            modifier = Modifier.clickable(onClick = {
                mNavController.navigate("SelectDirectComponent")

            }),
            headlineContent = { Text("备份选项", fontSize = 14.sp) },
            supportingContent = { Text("照片\n视频\n截屏", fontSize = 10.sp) },
            leadingContent = {
                Icon(
                    Icons.Default.SettingsBackupRestore,
                    contentDescription = "Home"
                )
            },
            shadowElevation = 4.dp,
        )

        ListItem(
            modifier = Modifier.clickable(onClick = {
                mNavController.navigate("SelectDirectComponent")
//                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT)
            }),
            headlineContent = { Text("同步选项", fontSize = 14.sp) },
            supportingContent = { Text("E:\\repo\nE:\\repo", fontSize = 10.sp) },
            leadingContent = {
                Icon(
                    Icons.Default.SyncLock,
                    contentDescription = "Home"
                )
            },
            shadowElevation = 4.dp,
        )
    }
}

@Composable
fun DrawerAlertDialog(
    title: String,
    onDismissRequest: () -> Unit,
    textFileValue: String,
    success: (index: String) -> Unit
) {

}


