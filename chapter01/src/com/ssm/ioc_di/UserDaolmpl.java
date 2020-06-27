package com.ssm.ioc_di;

public class UserDaolmpl implements UserDao {
    @Override
    public void login() {
        System.out.println("UserDao login");
    }
}
