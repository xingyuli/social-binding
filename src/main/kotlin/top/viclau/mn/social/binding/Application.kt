package top.viclau.mn.social.binding

import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Value
import io.micronaut.runtime.Micronaut
import me.chanjar.weixin.mp.api.WxMpService
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl
import org.jooq.Configuration
import top.viclau.mn.social.binding.db.tables.daos.AccountDao
import javax.inject.Singleton

@Factory
internal class WxMpFactory {

    @Value("$\{app.wx.app-id}")
    private lateinit var wxAppId: String

    @Value("$\{app.wx.secret}")
    private lateinit var wxSecret: String

    @Value("$\{app.wx.token}")
    private lateinit var wxToken: String

    @Singleton
    fun wxMpService(): WxMpService {
        val config = WxMpDefaultConfigImpl().apply {
            appId = wxAppId
            secret = wxSecret
            token = wxToken
        }
        return WxMpServiceImpl().apply { wxMpConfigStorage = config }
    }

}

@Factory
internal class JooqFactory(private val configuration: Configuration) {

    @Singleton
    fun accountDao() = AccountDao(configuration)

}

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("top.viclau.mn.social.binding")
                .mainClass(Application.javaClass)
                .start()
    }

}