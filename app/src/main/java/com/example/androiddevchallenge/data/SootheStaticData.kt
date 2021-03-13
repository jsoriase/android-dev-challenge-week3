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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.SootheActivity

class SootheStaticData {

    companion object {

        val favCollections = arrayListOf(
            SootheActivity("Short mantras", R.drawable.meditate),
            SootheActivity("Nature meditations", R.drawable.nature_meditation),
            SootheActivity("Stress and anxiety", R.drawable.stressandanxiety),
            SootheActivity("Self-massage", R.drawable.selfmassage),
            SootheActivity("Overwhelmed", R.drawable.overwhelmed),
            SootheActivity("Nightly wind down", R.drawable.nightlywinddown),
        )

        val alignYourBodyActivities = arrayListOf(
            SootheActivity("Inversions", R.drawable.inversions),
            SootheActivity("Quick Yoga", R.drawable.quick_yoga),
            SootheActivity("Stretching", R.drawable.stretching),
            SootheActivity("Tabata", R.drawable.tabata),
            SootheActivity("HIIT", R.drawable.hiit),
            SootheActivity("Pre-natal yoga", R.drawable.prenatal_yoga),

        )

        val alignYourMindActivities = arrayListOf(
            SootheActivity("Meditate", R.drawable.meditate),
            SootheActivity("With kids", R.drawable.with_kids),
            SootheActivity("Aromatherapy", R.drawable.aromatherapy),
            SootheActivity("On the go", R.drawable.onthego),
            SootheActivity("With pets", R.drawable.withpets),
            SootheActivity("High stress", R.drawable.highstress),
        )
    }
}
