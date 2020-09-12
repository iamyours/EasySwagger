package com.example.easyswagger.vo


/**
 * 登录用户实体
 * @author iamyours
 * @since 2020/9/12
 */
class LoginUser(
        val userName: String,   //登录用户名
        val password: String    //密码
) {
    var icon: String? = null    //头像
    var age: Int? = null        //年龄
    var nickName: String? = null //昵称
}