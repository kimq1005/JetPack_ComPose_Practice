package test.map.jetpack_compose_practice.model.logtark

import java.io.Serializable

data class CharacterModel(
    val ServerName:String,
    val CharacterName :String,
    val CharacterLevel : Int,
    val CharacterClassName :String,
    val ItemAvgLevel: String,
    val ItemMaxLevel:String
):Serializable