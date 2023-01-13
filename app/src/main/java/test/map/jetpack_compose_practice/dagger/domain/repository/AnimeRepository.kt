package test.map.jetpack_compose_practice.dagger.domain.repository

import llama.test.jetpack_compose_dagger2.data.dto.TestDTO

interface AnimeRepository {

    suspend fun getAnimeList() : TestDTO

}