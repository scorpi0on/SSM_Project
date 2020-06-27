package com.ssm.ioc_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoC {
    public static void main(String[] args) {
        //初始化spring容器，加载配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取实例
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        //调用方法
        userDao.login();
    }
}
