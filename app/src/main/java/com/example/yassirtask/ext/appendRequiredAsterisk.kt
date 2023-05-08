package com.example.yassirtask.ext

fun String.appendRequiredAsterisk(isRequired: Boolean) = if (isRequired) "$this*" else this
