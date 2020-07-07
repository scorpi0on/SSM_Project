package com.ssm.test;

import com.ssm.dao.UserDao;
import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    @Test
    public void findUserByIdTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByIdMapperTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
