package test.map.jetpack_compose_practice.dagger.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import llama.test.jetpack_compose_dagger2.common.Constant
import llama.test.jetpack_compose_dagger2.data.AnimeinstanceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.map.jetpack_compose_practice.dagger.data.repository.AnimeRepositoryImplementation
import test.map.jetpack_compose_practice.dagger.domain.repository.AnimeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AnimeModule {

    @Provides
    @Singleton
    fun provideApi() : AnimeinstanceAPI{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeinstanceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(api:AnimeinstanceAPI) : AnimeRepository{
        return AnimeRepositoryImplementation(api)
    }
}