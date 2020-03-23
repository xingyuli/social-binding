package top.viclau.mn.social.binding.service

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HitokotoService {

    @field:Client("https://v1.hitokoto.cn")
    @Inject
    private lateinit var httpClient: RxHttpClient

    fun get(): HitokotoMessage = httpClient.toBlocking().retrieve("", HitokotoMessage::class.java)

}

data class HitokotoMessage(
    val id: Long,
    val hitokoto: String,
    val type: String,
    val from: String?,
    val from_who: String?,
    val creator: String,
    val creator_uid: Long,
    val reviewer: Long,
    val uuid: String,
    val created_at: Long
)
