package test.map.jetpack_compose_practice.dagger.data.repository

import llama.test.jetpack_compose_dagger2.data.AnimeinstanceAPI
import llama.test.jetpack_compose_dagger2.data.dto.TestDTO
import test.map.jetpack_compose_practice.dagger.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImplementation  @Inject constructor(
    private val api: AnimeinstanceAPI
): AnimeRepository{

    override suspend fun getAnimeList(): TestDTO {
        return api.getAnimeList()
    }
}