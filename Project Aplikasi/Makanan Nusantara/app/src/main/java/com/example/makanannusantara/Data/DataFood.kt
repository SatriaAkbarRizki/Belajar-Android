package com.example.makanannusantara.Data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataFood(
    var nameFood : String,
    var imageFood : Int,
    var descriptionFood : String
) : Parcelable
