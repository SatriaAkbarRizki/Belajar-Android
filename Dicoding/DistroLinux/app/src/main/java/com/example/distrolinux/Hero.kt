package com.example.distrolinux

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name : String,
    var description : String,
    var photo : Int
) : Parcelable