package com.elchinasgarov.cryptotracker.core.data.networking

import com.elchinasgarov.cryptotracker.BuildConfig

fun constructURL(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
        else -> BuildConfig.BASE_URL + url
    }
}