package com.example.easyswagger.controller

import com.example.easyswagger.vo.LoginUser
import org.springframework.web.bind.annotation.*


/**
 * 登录相关接口
 * @author iamyours
 * @since 2020/9/12
 */
@RestController
@RequestMapping("web/v1/login")
class LoginUserController {
    /**
     * 登录
     * @param username 用户名|required|test123
     * @param password 密码|required
     */
    @PostMapping("login")
    fun login(username: String, @RequestParam("pwd") password: String): LoginUser {
        return LoginUser(username, password).apply { nickName = "login:$username" }
    }

    @PostMapping("register")
    fun register(username: String, password: String): LoginUser {
        return LoginUser(username, password)
    }

    /**
     * 获取登录用户列表
     */
    @GetMapping("login-list")
    fun loginList(): List<LoginUser> {
        return listOf(LoginUser("test", ""))
    }
}