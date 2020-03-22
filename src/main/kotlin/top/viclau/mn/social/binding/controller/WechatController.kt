package top.viclau.mn.social.binding.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import me.chanjar.weixin.mp.api.WxMpService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import top.viclau.mn.social.binding.service.AccountService
import javax.inject.Inject

@Controller("/wechat")
class WechatController {

    private val log: Logger = LoggerFactory.getLogger(WechatController::class.java)

    @Inject
    private lateinit var wxMpService: WxMpService

    @Inject
    private lateinit var accountService: AccountService

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    fun verifySignature(
        @QueryValue signature: String,
        @QueryValue echostr: String,
        @QueryValue timestamp: String,
        @QueryValue nonce: String
    ): String {
        return if (wxMpService.checkSignature(timestamp, nonce, signature)) echostr else "-1"
    }

    @Consumes(MediaType.TEXT_XML, MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Post
    fun handleMessage(
        ToUserName: String,
        FromUserName: String,
        CreateTime: String,
        MsgType: String,
        Event: String?,
        EventKey: String?
    ): String {
        log.debug("""
                  ToUserName=${ToUserName}
                  FromUserName=${FromUserName}
                  CreateTime=${CreateTime}
                  MsgType=${MsgType}
                  Event=${Event}
                  EventKey=${EventKey}""".trimIndent())

        if (MsgType == "event") {
            when (Event) {
                "subscribe" -> accountService.onWxSubscribe(FromUserName)
                "unsubscribe" -> accountService.onWxUnsubscribe(FromUserName)
            }
        }
        return "1"
    }

//    @Get(uri = "/qrCodePictureUrl", produces = [MediaType.TEXT_PLAIN])
//    fun qrcodePictureUrl(): String {
//        val ticket = wxMpService.qrcodeService.qrCodeCreateLastTicket("hexo_blog");
//        return wxMpService.qrcodeService.qrCodePictureUrl(ticket.ticket)
//    }

}