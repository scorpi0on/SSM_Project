package com.ssm.test;

import com.ssm.po.Banji;
import com.ssm.po.Course;
import com.ssm.po.Student;
import com.ssm.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisAssociationTest {
// one to one
//嵌套查询
    @Test
    public void findStudentByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Student student =
                sqlSession.selectOne("com.ssm.mapper.StudentMapper.findStudentById",1);
        System.out.println(student.toString());
        sqlSession.close();
    }
//嵌套结果
    @Test
    public void findStudentById2Test(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Student student =
                sqlSession.selectOne("com.ssm.mapper.StudentMapper.findStudentById2",1);
        System.out.println(student.toString());
        sqlSession.close();
    }
//one to many
    @Test
    public void findBanjiTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Banji banji =
                sqlSession.selectOne("com.ssm.mapper.BanjiMapper.findBanjiWithStudent",1);
        System.out.println(banji.toString());
        sqlSession.close();

    }
//many to many
    @Test
    public void findCourseWithStudentByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Course course = sqlSession.selectOne("com.ssm.mapper.CourseMapper.findCourseWithStudent2",1);
        System.out.println(course);
        sqlSession.close();
    }
    @Test
    public void findStudentWithCourseByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        Student student = sqlSession.selectOne("com.ssm.mapper.StudentMapper.findCourseByStudent2",1);
        System.out.println(student);
        sqlSession.close();
    }

}
