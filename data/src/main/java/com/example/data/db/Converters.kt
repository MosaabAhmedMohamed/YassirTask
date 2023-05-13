package com.example.data.db

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromStringList(list: List<String>?): String {
        return list?.joinToString(",")?:""
    }

    @TypeConverter
    fun fromStringToList(string: String?): List<String> {
        return string?.split(",")?: emptyList()
    }

}