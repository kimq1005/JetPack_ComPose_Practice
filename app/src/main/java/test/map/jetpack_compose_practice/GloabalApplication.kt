package test.map.jetpack_compose_practice

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GloabalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_native_key))
    }
}