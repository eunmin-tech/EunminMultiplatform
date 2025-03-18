package io.eunmin.multiplatform.pokedex.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.eunmin.multiplatform.common.extensions.urlToId
import io.eunmin.multiplatform.pokedex.data.datasource.PokemonRemoteDataSource
import io.eunmin.multiplatform.pokedex.data.model.PokemonSummaryEntity

class PokemonSummaryPagingSource(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
): PagingSource<Int, PokemonSummaryEntity>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonSummaryEntity>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonSummaryEntity> {
        val page = params.key ?: 1
        return try {
            val response = pokemonRemoteDataSource.fetchPokemonList(page, params.loadSize)
            LoadResult.Page(
                data = response.results,
                prevKey = response.previous?.urlToId(),
                nextKey = response.next?.urlToId()
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}