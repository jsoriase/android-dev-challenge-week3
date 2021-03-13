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
package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun SearchBox() {
    Box(
        modifier = Modifier
            .padding(end = 16.dp)
            .background(MaterialTheme.colors.surface)
    ) {

        TextField(
            value = "Search", onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                textColor = MaterialTheme.colors.onSurface,
            )
        )

        Icon(
            Icons.Outlined.Search,
            contentDescription = "Search",
            modifier = Modifier.padding(start = 18.dp),
            tint = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun SearchBoxLightPreview() {
    MyTheme {
        SearchBox()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun SearchBoxDarkPreview() {
    MyTheme(darkTheme = true) {
        SearchBox()
    }
}
