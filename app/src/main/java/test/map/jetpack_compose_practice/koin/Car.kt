package test.map.jetpack_compose_practice.koin

import android.util.Log
import test.map.jetpack_compose_practice.Utils.Companion.TAG

class Car(var engine: Engine) {
    fun startCar(){
        Log.d(TAG, "카카카카 위에 있는거 start Car!")
    }
}

class Engine{
    fun start(){
        Log.d(TAG, "엔진엔진 아래 있는거 Start Engine")
    }
}