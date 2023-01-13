package llama.test.jetpack_compose_dagger2.data.dto

import java.io.Serializable


data class Video(
    val description: String?,
    val sources: List<String>?,
    val subtitle: String?,
    val thumb: String?,
    val title: String?
):Serializable