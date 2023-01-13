package llama.test.jetpack_compose_dagger2.data

import llama.test.jetpack_compose_dagger2.data.dto.TestDTO
import retrofit2.http.GET

interface AnimeinstanceAPI {
    //    https://run.mocky.io/v3/24a02ac1-5208-445f-87c0-b366891d0b85
    @GET("/v3/24a02ac1-5208-445f-87c0-b366891d0b85")
    suspend fun getAnimeList() : TestDTO
    
}