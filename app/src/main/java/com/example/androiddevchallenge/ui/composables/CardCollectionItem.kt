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

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun CardCollectionItem(name: String, drawable: Int) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.height(56.dp).width(192.dp),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = name,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = name,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 16.dp, end = 4.dp),
                maxLines = 2
            )
        }
    }
}

@Preview("Light Theme")
@Composable
fun CardCollectionItemLightPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.surface) {
            CardCollectionItem("Stress and anxiety", R.drawable.stretching)
        }
    }
}

@Preview("Dark Theme")
@Composable
fun CardCollectionItemDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.surface) {
            CardCollectionItem("Nightly wind down", R.drawable.stretching)
        }
    }
}
