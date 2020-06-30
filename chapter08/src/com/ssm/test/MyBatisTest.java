package com.ssm.test;

import com.ssm.po.User;
import com.ssm.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MyBatisTest {
//select
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
// select
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
//add
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
// update with set
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
//        user.setUsername("tom");
        user.setJobs("teacher");
//        user.setPhone("1234654326");

        int rows = sqlSession.update("com.ssm.mapper.UserMapper.updateUser", user);
        if (rows > 0){
            System.out.println("successfully update " + rows + " records");
        }else{
            System.out.println("Fail to update record");
        }

        sqlSession.commit();
        sqlSession.close();
    }
//delete
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
//if
    @Test
    public void findUserByNameAndJobsTest() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSession();
        User user=new User();
        user.setUsername("zhangsan");
        user.setJobs("teacher");
        List<User> users =
                sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByNameAndJobs",user);
        for (User u : users){
            System.out.println(u.toString());
        }
        sqlSession.close();
    }
//where
    @Test
    public void findUserByNameOrJobsTest() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSession();
        User user=new User();
//        user.setUsername("zhangsan");
        user.setJobs("teacher");
        List<User> users =
                sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByNameOrJobs",user);
        for (User u : users){
            System.out.println(u.toString());
        }
        sqlSession.close();
    }
//foreach
    @Test
    public void findUserByIdsTest(){
        SqlSession sqlSession = new MybatisUtil().getSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByIds", ids);
        for (User user : users){
            System.out.println(user.toString());
        }
        sqlSession.close();
    }
//bind
    @Test
    public void findUserByName2Test(){
        SqlSession sqlSession = MybatisUtil.getSession();
        User user=new User();
        user.setUsername("s");
        List<User> users = sqlSession.selectList("com.ssm.mapper.UserMapper.findUserByName2", user);
        for (User u : users){
            System.out.println(u.toString());
        }
        sqlSession.close();
        }
}