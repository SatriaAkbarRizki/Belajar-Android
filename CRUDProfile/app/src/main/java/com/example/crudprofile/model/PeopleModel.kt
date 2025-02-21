package com.example.crudprofile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleModel(
    val id : String,
    val name: String,
    val avatar: String,
    val address : String
) : Parcelable
