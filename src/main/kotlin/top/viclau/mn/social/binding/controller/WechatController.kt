package top.viclau.mn.social.binding.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import me.chanjar.weixin.mp.api.WxMpService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import top.viclau.mn.social.binding.service.AccountService
import top.viclau.mn.social.binding.service.HitokotoService
import top.viclau.mn.social.binding.service.WxMpMessageOutput.WxMpTextMessageOutput
import javax.inject.Inject

@Controller("/wechat")
class WechatController {

    private val log: Logger = LoggerFactory.getLogger(WechatController::class.java)

    @Inject
    private lateinit var wxMpService: WxMpService

    @Inject
    private lateinit var accountService: AccountService

    @Inject
    private lateinit var hitokotoService: HitokotoService

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
    @Produces(MediaType.TEXT_XML)
    @Post
    fun handleMessage(
        ToUserName: String,
        FromUserName: String,
        CreateTime: String,
        MsgType: String,
        Event: String?,
        EventKey: String?
    ): Any {
        log.debug("""
                  ToUserName=${ToUserName}
                  FromUserName=${FromUserName}
                  CreateTime=${CreateTime}
                  MsgType=${MsgType}
                  Event=${Event}
                  EventKey=${EventKey}""".trimIndent())

        return when (MsgType) {
            "event" -> handleEvent(Event!!, FromUserName)
            "text", "image", "voice", "video", "shortvideo", "location", "link" -> handleNormalMessage(FromUserName, ToUserName)
            else -> "success"
        }
    }

    private fun handleNormalMessage(fromUserName: String, toUserName: String): WxMpTextMessageOutput {
        val content = hitokotoService.get().let { "${it.hitokoto}\r\n\r\n—— ${it.from}" }
        return WxMpTextMessageOutput(fromUserName, toUserName, System.currentTimeMillis() / 1000, content)
    }

    private fun handleEvent(event: String, fromUserName: String): String {
        when (event) {
            "subscribe" -> accountService.onWxSubscribe(fromUserName)
            "unsubscribe" -> accountService.onWxUnsubscribe(fromUserName)
        }
        return "success"
    }

//    @Get(uri = "/qrCodePictureUrl", produces = [MediaType.TEXT_PLAIN])
//    fun qrcodePictureUrl(): String {
//        val ticket = wxMpService.qrcodeService.qrCodeCreateLastTicket("hexo_blog");
//        return wxMpService.qrcodeService.qrCodePictureUrl(ticket.ticket)
//    }

}