package com.sennohananto.intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimalParcelable(val name: String, val color: String, val legs: Int, val environment: String) : Parcelable