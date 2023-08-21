package com.desafiolatam.intentsbundlem5_g8.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val id: Int,
    val name: String,
    val age: Int
        ) : Parcelable