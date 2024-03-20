package com.example.foodinfo.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recipes(
    val day: String,
    val title: String,
    val image:Int,
    val description: String
)
