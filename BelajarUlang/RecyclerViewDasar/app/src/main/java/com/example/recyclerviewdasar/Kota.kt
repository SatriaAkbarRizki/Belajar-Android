package com.example.recyclerviewdasar

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kota(
    var name : String,
    var image : Int,
    var description : String
): Parcelable
