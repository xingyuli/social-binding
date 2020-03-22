package top.viclau.mn.social.binding

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import me.chanjar.weixin.mp.api.WxMpService
import javax.inject.Inject

@Controller("/wechat")
class WechatController {

    @Inject
    private lateinit var wxMpServie: WxMpService

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(@QueryValue signature: String,
              @QueryValue echostr: String,
              @QueryValue timestamp: String,
              @QueryValue nonce: String): String {
        return if (wxMpServie.checkSignature(timestamp, nonce, signature)) echostr else "-1"
    }

}