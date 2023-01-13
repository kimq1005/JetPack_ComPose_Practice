package test.map.jetpack_compose_practice.dagger.domain.use_case

import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import test.map.jetpack_compose_practice.dagger.common.Events
import test.map.jetpack_compose_practice.dagger.domain.model.AnimeData
import test.map.jetpack_compose_practice.dagger.domain.repository.AnimeRepository
import java.io.IOException
import java.util.*
import java.util.concurrent.Flow
import javax.inject.Inject

class AnimeGetUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
    operator fun invoke() : kotlinx.coroutines.flow.Flow<Events<List<AnimeData>>> = flow{
        try{
            emit(Events.Loading<List<AnimeData>>())
            val animeData = repository.getAnimeList().videos

            emit(Events.Success<List<AnimeData>>(animeData))
        }
        catch (e: HttpException){
            emit(Events.Error<List<AnimeData>>(message = e.localizedMessage?:"An Unexpected Error Occurred"))
        }
        catch (e: IOException){
            emit(Events.Error<List<AnimeData>>(message = "Could Not Reach the server due to Internet Connection Loss"))
        }
    }
}