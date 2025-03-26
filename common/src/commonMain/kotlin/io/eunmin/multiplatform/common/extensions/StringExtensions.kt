package io.eunmin.multiplatform.common.extensions

fun String.urlToId(): Int = "/-?[0-9]+/$".toRegex().find(this)!!.value.filter { it.isDigit() || it == '-' }.toInt()