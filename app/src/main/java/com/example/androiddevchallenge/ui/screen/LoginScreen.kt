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

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.firstBaselineToTop
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun LoginScreen(navController: NavController) {
    val background = if (isSystemInDarkTheme()) {
        painterResource(id = R.drawable.ic_dark_login)
    } else {
        painterResource(id = R.drawable.ic_light_login)
    }

    Surface(color = MaterialTheme.colors.background) {

        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = background,
                contentDescription = "Background Image",
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "LOG IN",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .firstBaselineToTop(200.dp)
                )
                Spacer(modifier = Modifier.padding(32.dp))

                TextField(
                    label = {
                        Text(
                            text = "Email address",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    },
                    value = "",
                    onValueChange = { },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    textStyle = MaterialTheme.typography.body1,

                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                    ),
                    shape = MaterialTheme.shapes.small
                )

                Spacer(modifier = Modifier.padding(8.dp))

                TextField(
                    label = {
                        Text(
                            text = "Password",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    },
                    value = "",
                    onValueChange = { },

                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface,
                        textColor = MaterialTheme.colors.onSurface,
                    ),
                    shape = MaterialTheme.shapes.small
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Button(
                    onClick = { navController.navigate("private") },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .padding(horizontal = 16.dp)
                        .height(72.dp)
                        .fillMaxWidth()
                        .clip(shapes.medium),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                ) {
                    Text(
                        text = "LOG IN",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                val text = with(AnnotatedString.Builder()) {
                    append("Dont have an account? ")
                    pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                    append("Sign up")
                    toAnnotatedString()
                }

                Text(
                    text = text,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .firstBaselineToTop(32.dp)
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenLightPreview() {
    val navController = rememberNavController()
    MyTheme {
        LoginScreen(navController)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}
