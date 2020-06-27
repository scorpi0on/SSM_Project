package com.ssm.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table user(" +
                "id int  primary key auto_increment," +
                " username varchar(40), " +
                "password varchar(40))");
    }
    @Test
    public void addUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User();
        user.setUsername("Taosha");
        user.setPassword("0303");

        int num = userDao.addUser(user);
        if (num > 0){
            System.out.println("Successful");
        }else {
            System.out.println("Failed");
        }
    }

    @Test
    public void updateUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User();
        user.setId(2);
        user.setUsername("Taosha");
        user.setPassword("19940303");

        int num = userDao.updateUser(user);
        if (num > 0){
            System.out.println("Successful");
        }else {
            System.out.println("Failed");
        }

    }

    @Test
    public void deleteUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        int num = userDao.deletUser(1);

        if (num > 0){
            System.out.println("Successful");
        }else {
            System.out.println("Failed");
        }
    }

    @Test
    public void findUserByIdTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        User user = userDao.findUserById(2);

        System.out.println(user);
    }

    @Test
    public void findAllUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        List<User> users = userDao.findAllUser();

        for (User user:users) {
            System.out.println(user);
        }
    }

    @Test
    public void xmlTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        userDao.transfer("tt","cc",100);
        System.out.println("Successfully");
    }

    @Test
    public void annotationTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");

        userDao.transfer("tt","cc",200);
        System.out.println("Successfully");
    }
}
