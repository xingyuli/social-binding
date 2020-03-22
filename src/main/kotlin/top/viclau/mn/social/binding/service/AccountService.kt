package top.viclau.mn.social.binding.service

import me.chanjar.weixin.mp.api.WxMpService
import org.jooq.DSLContext
import org.jooq.impl.DSL
import top.viclau.mn.social.binding.db.Tables.ACCOUNT
import top.viclau.mn.social.binding.db.enums.AccountStatus
import top.viclau.mn.social.binding.db.enums.AccountType
import top.viclau.mn.social.binding.db.tables.daos.AccountDao
import top.viclau.mn.social.binding.db.tables.pojos.Account
import top.viclau.mn.social.binding.db.tables.records.AccountRecord
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
class AccountService(
    private val dslContext: DSLContext,
    private val accountDao: AccountDao,
    private val wxMpService: WxMpService
) {

    fun onWxSubscribe(openId: String) {
        val account = findOneByExtIdentifier(AccountType.WECHAT, openId)

        if (account != null) {
            updateStatus(account, AccountStatus.SUBSCRIBED)

        } else {
            val wxUserInfo = wxMpService.userService.userInfo(openId)
            accountDao.insert(Account().apply {
                type = AccountType.WECHAT
                extIdentifier = wxUserInfo.openId
                extName = wxUserInfo.nickname
                avatar = wxUserInfo.headImgUrl
                status = AccountStatus.SUBSCRIBED
                createdAt = LocalDateTime.now()
                updatedAt = LocalDateTime.now()
            })
        }
    }

    fun onWxUnsubscribe(openId: String) {
        val account = findOneByExtIdentifier(AccountType.WECHAT, openId)
        account?.let {
            updateStatus(it, AccountStatus.UNSUBSCRIBED)
        }
    }

    private fun findOneByExtIdentifier(type: AccountType, extIdentifier: String): AccountRecord? {
        return dslContext.selectFrom(ACCOUNT)
            .where(ACCOUNT.TYPE.eq(type))
            .and(ACCOUNT.EXT_IDENTIFIER.eq(extIdentifier))
            .fetchOne()
    }

    private fun updateStatus(account: AccountRecord, status: AccountStatus) {
        account.status = status
        account.updatedAt = LocalDateTime.now()
        account.update()
    }

    fun countGrouped(): Map<AccountType, Int> {
        val countColumn = DSL.count().`as`("count")

        val records = dslContext.select(ACCOUNT.TYPE, countColumn)
            .from(ACCOUNT)
            .groupBy(ACCOUNT.TYPE)
            .fetch()

        val result = records.intoMap(ACCOUNT.TYPE, countColumn)

        // default to 0
        AccountType.values().forEach {
            result.putIfAbsent(it, 0)
        }

        return result
    }

}