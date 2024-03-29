package com.practice.management.bean.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录认证对象模型
 */
public class AuthModel {
    /**
     * 账户
     */
    @NotBlank(message = "用户名不能为空")
    private String account;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 认证关联的id：学校id/企业id/管理员(0L)
     */
    @NotNull(message = "未选择登录结构")
    private Long foreignId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getForeignId() {
        return foreignId;
    }

    public void setForeignId(Long foreignId) {
        this.foreignId = foreignId;
    }
}
