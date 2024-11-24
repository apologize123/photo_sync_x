package com.example.photo_sync_x

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.photo_sync_x.component.HomeComponent
import com.example.photo_sync_x.component.SelectDirectComponent

@SuppressLint("StaticFieldLeak")
lateinit var mNavController: NavHostController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                DemoNavigation()
            }
        }
    }

    @Composable
    fun DemoNavigation() {
        //创建导航控制器
        mNavController = rememberNavController()
        //创建NavHost导航组建者，传入了mNavController 导航控制器 与 首个显示的页面 startDestination = APage
        NavHost(
            navController = mNavController,
            startDestination = "HomeComponent"
        ) {
            composable(route = "HomeComponent") { HomeComponent() }
            composable(route = "SelectDirectComponent") { SelectDirectComponent() }
        }
    }
}
