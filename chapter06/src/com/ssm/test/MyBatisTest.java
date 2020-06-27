package com.ssm.test;

import com.ssm.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class MyBatisTest {
    @org.junit.Test
    public void findUserByIdTest() throws Exception{
//        1.读取配置文件
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据配置文件构建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.SqlSession执行映射文件中定义的SQL, 并分会映射结果
        User user = sqlSession.selectOne("com.ssm.mapper.UserMapper.findUserById", 1);
//        5.打印输出结果
        System.out.println(user.toString());
//        6.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws Exception{
        //        1.读取配置文件
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据配置文件构建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.SqlSession执行映射文件中定义的SQL, 并分会映射结果
        List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByName", "g");
//        5.打印输出结果
        for (User user : users){
            System.out.println(user.toString());
        }
//        6.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addUserTest() throws Exception{
        //        1.读取配置文件
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据配置文件构建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建 用户对象
        User user  = new User();
        user.setUsername("tom");
        user.setJobs("worker");
        user.setPhone("1234654326");

        int rows = sqlSession.insert("com.ssm.mapper.UserMapper.addUser", user);
        if (rows > 0){
            System.out.println("successfully add " + rows + " records");
        }else{
            System.out.println("Fail to add record");
        }

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUserTest() throws Exception{
        //        1.读取配置文件
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据配置文件构建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建 用户对象
        User user  = new User();
        user.setId(4);
        user.setUsername("tom");
        user.setJobs("teacher");
        user.setPhone("1234654326");

        int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUser", user);
        if (rows > 0){
            System.out.println("successfully update " + rows + " records");
        }else{
            System.out.println("Fail to update record");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() throws Exception{
        //        1.读取配置文件
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        2.根据配置文件构建SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        3.通过SqlSessionFactory创建SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int rows = sqlSession.update("com.ssm.mapper.UserMapper.deleteUser", 5);
        if (rows > 0){
            System.out.println("successfully delete " + rows + " records");
        }else{
            System.out.println("Fail to delete record");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
