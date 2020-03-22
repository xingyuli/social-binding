package top.viclau.mn.social.binding.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import top.viclau.mn.social.binding.service.AccountService

@Controller("/count")
class CountController(private val accountService: AccountService) {

    @Get("/users")
    fun users() = accountService.countGrouped()

}