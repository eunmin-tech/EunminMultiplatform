package io.eunmin.multiplatform.pokedex.remote.di

import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.remote.api.PokemonApi
import io.eunmin.multiplatform.pokedex.remote.impl.PokemonRemoteDataSourceImpl
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun createHttpClient(): HttpClient

val pokedexRemoteModules = module {
    single {
        createHttpClient().config {
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(HttpTimeout) { requestTimeoutMillis = 10000 }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(message)
                    }
                }
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                })
            }
        }
    }

    singleOf(::PokemonRemoteDataSourceImpl) bind PokemonRemoteDataSource::class
    singleOf(::PokemonApi)
}