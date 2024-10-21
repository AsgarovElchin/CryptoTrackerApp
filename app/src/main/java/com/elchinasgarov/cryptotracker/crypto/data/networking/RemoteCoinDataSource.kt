package com.elchinasgarov.cryptotracker.crypto.data.networking

import com.elchinasgarov.cryptotracker.core.data.networking.constructURL
import com.elchinasgarov.cryptotracker.core.data.networking.safeCall
import com.elchinasgarov.cryptotracker.core.domain.util.NetworkError
import com.elchinasgarov.cryptotracker.core.domain.util.Result
import com.elchinasgarov.cryptotracker.core.domain.util.map
import com.elchinasgarov.cryptotracker.crypto.data.mappers.toCoin
import com.elchinasgarov.cryptotracker.crypto.data.networking.dto.CoinResponseDto
import com.elchinasgarov.cryptotracker.crypto.domain.Coin
import com.elchinasgarov.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructURL("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}