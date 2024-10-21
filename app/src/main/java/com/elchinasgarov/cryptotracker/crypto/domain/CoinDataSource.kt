package com.elchinasgarov.cryptotracker.crypto.domain

import com.elchinasgarov.cryptotracker.core.domain.util.NetworkError
import com.elchinasgarov.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}