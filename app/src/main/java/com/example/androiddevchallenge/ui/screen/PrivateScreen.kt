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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.SootheStaticData
import com.example.androiddevchallenge.firstBaselineToTop
import com.example.androiddevchallenge.ui.composables.CardCollectionItem
import com.example.androiddevchallenge.ui.composables.RoundedImageWithName
import com.example.androiddevchallenge.ui.theme.MyTheme

// Start building your app here!
@Composable
fun PrivateScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = {
                MySootheBottomNavigation()
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {}
                ) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                TextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 56.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    textStyle = MaterialTheme.typography.body1,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = MaterialTheme.shapes.small
                )
                Text(
                    "FAVORITE COLLECTIONS",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.firstBaselineToTop(40.dp).padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(modifier = Modifier.padding(start = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(end = 16.dp)) {
                    items(
                        SootheStaticData.favCollections.chunked(2)
                            .map { it[0] to it[1] }
                    ) { pair ->
                        Column {
                            CardCollectionItem(name = pair.first.name, drawable = pair.first.image)
                            Spacer(modifier = Modifier.height(8.dp))
                            CardCollectionItem(name = pair.second.name, drawable = pair.second.image)
                        }
                    }
                }

                Text(
                    "ALIGN YOUR BODY",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.firstBaselineToTop(48.dp).padding(start = 16.dp)
                )
                LazyRow(modifier = Modifier.padding(top = 8.dp, start = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(end = 16.dp)) {
                    items(SootheStaticData.alignYourBodyActivities) { alignYourBody ->
                        RoundedImageWithName(name = alignYourBody.name, drawable = alignYourBody.image)
                    }
                }

                Text(
                    "ALIGN YOUR MIND",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.firstBaselineToTop(48.dp).padding(start = 16.dp)
                )
                LazyRow(modifier = Modifier.padding(top = 8.dp, start = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(end = 16.dp)) {
                    items(SootheStaticData.alignYourMindActivities) { alignYourMind ->
                        RoundedImageWithName(name = alignYourMind.name, drawable = alignYourMind.image)
                    }
                }
            }
        }
    }
}

@Composable
private fun MySootheBottomNavigation() {
    BottomNavigation( // BottomAppBar?
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Spa, contentDescription = "home") },
            label = {
                Text(
                    text = "HOME",
                    style = MaterialTheme.typography.caption
                )
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile") },
            label = {
                Text(
                    text = "PROFILE",
                    style = MaterialTheme.typography.caption
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PrivateScreenLightPreview() {
    val navController = rememberNavController()
    MyTheme {
        PrivateScreen(navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PrivateScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        val navController = rememberNavController()
        PrivateScreen(navController)
    }
}
