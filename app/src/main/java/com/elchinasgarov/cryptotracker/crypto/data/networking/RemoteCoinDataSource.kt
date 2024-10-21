package com.elchinasgarov.cryptotracker.crypto.data.networking

import com.elchinasgarov.cryptotracker.core.data.networking.safeCall
import com.elchinasgarov.cryptotracker.core.domain.util.NetworkError
import com.elchinasgarov.cryptotracker.core.domain.util.Result
import com.elchinasgarov.cryptotracker.crypto.domain.Coin
import com.elchinasgarov.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
):CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall {
            httpClient.get()
        }
    }
}