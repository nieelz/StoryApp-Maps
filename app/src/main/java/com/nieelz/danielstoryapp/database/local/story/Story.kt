package com.nieelz.danielstoryapp.database.local.story

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Story(
    val photoUrl: String,
    val createdAt: String,
    val name: String,
    val description: String,
    val lon: Double,
    val id: String,
    val lat: Double
) : Parcelable