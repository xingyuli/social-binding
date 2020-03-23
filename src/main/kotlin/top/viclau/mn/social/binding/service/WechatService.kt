package top.viclau.mn.social.binding.service

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "xml")
sealed class WxMpMessageOutput(
    @get:JacksonXmlCData
    @get:JacksonXmlProperty(localName = "ToUserName") open val toUserName: String,

    @get:JacksonXmlCData
    @get:JacksonXmlProperty(localName = "FromUserName") open val fromUserName: String,

    @get:JacksonXmlProperty(localName = "CreateTime") open val createTime: Long,

    @get:JacksonXmlCData
    @get:JacksonXmlProperty(localName = "MsgType") open val msgType: String
) {

    data class WxMpTextMessageOutput(
        override val toUserName: String, override val fromUserName: String, override val createTime: Long,
        @get:JacksonXmlCData
        @get:JacksonXmlProperty(localName = "Content") val content: String
    ) : WxMpMessageOutput(toUserName, fromUserName, createTime, "text")

}
