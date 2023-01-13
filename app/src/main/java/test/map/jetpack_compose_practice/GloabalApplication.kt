package test.map.jetpack_compose_practice

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import test.map.jetpack_compose_practice.koin.Car
import test.map.jetpack_compose_practice.koin.Engine
import test.map.jetpack_compose_practice.koin.networkModule

class GloabalApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        //kakao login
        KakaoSdk.init(this, getString(R.string.kakao_native_key))

        //startKoin
//        startKoin {
//            androidContext(this@GloabalApplication)
//            androidLogger()
//
//        }

    }
}

val appModule = module {
    single { Engine() }
    factory { Car(get()) }
}