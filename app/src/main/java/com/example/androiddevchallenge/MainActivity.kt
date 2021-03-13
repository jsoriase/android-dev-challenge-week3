/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screen.LoginScreen
import com.example.androiddevchallenge.ui.screen.PrivateScreen
import com.example.androiddevchallenge.ui.screen.PublicScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {
            MyTheme {
                window.statusBarColor = MaterialTheme.colors.background.toArgb()
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "public") {
        composable("public") { PublicScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("private") { PrivateScreen(navController) }
    }
}
