package test.map.jetpack_compose_practice

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _name = mutableStateOf("하윙")
    val name :State<String> = _name

    private val _password = mutableStateOf("")
    val password:State<String> = _password


    fun savemyname(){

    }

}