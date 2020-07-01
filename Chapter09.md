# MyBatis Association Mapping

## 关联关系

### 一对一
Student 和 StudentIdCard 的关联
1. 嵌套查询进行关联查询的效率 比 嵌套结果的关联查询的方式 低
2. mybatis提供延迟加载来缓解嵌套查询进行关联查询。
```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ssm.mapper.StudentIdCardMapper">
    <select id="findStudentIdCardById" parameterType="Integer" resultType="StudentIdCard">
        select * from tb_studentidcard where id = #{id}
    </select>
</mapper>
```


```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ssm.mapper.StudentMapper">
    <select id="findStudentById" parameterType="Integer" resultMap="StudentIdCardWithStudentResult">
        select * from tb_student where id = #{id}
    </select>
    <resultMap id="StudentIdCardWithStudentResult" type="Student">
        <result property="name" column="name"/>
        <result property="sex" column="sex" />
<!--one to one, Association with select -->
        <association property="studentIdCard" column="card_id" javaType="StudentIdCard"
                     select="com.ssm.mapper.StudentIdCardMapper.findStudentIdCardById" />
    </resultMap>

    <select id="findStudentById2" parameterType="Integer" resultMap="StudentIdCardWithStudentResult2">
        select s.*, sidcard.code
        from tb_student s, tb_studentidcard sidcard
        where s.card_id = sidcard.id and s.id=#{id}
    </select>
    <resultMap id="StudentIdCardWithStudentResult2" type="Student">
        <id property="id" column="id" />
        <result property="name" column="name" />
        <result property="sex" column="sex" />
        <association property="studentIdCard" javaType="StudentIdCard">
            <id property="id" column="id" />
            <result property="code" column="code" />
        </association>
    </resultMap>
</mapper>
```

### 一对多
1. 关联查询出现列重名，需要使用别名。
```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ssm.mapper.BanjiMapper">
    <select id="findBanjiWithStudent" parameterType="Integer"
            resultMap="BanjiWithStudentResult">
        select b.*, s.id as student_id, s.name as student_name, s.sex as student_sex from tb_banji b, tb_student s
        where b.id = s.banji_id and b.id = ${id}
    </select>
    <resultMap id="BanjiWithStudentResult" type="Banji">
        <id property="id" column="id" />
        <result property="name" column="name" />
        <collection property="studentList" ofType="Student">
            <id property="id" column="student_id" />
            <result property="name" column="student_name" />
            <result property="sex" column="student_sex" />
        </collection>
    </resultMap>
</mapper>
```
### 多对多
1. 多对多关系通常需要一个中间表来维护这个关系，例如tb_electiveCourse维护tb_student和tb_course的关系。
```xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.ssm.mapper.CourseMapper">
    <select id="findCourseWithStudent" parameterType="Integer" resultMap="CourseWithStudentResult">
        select * from tb_course where id = #{id}
    </select>
    <resultMap id="CourseWithStudentResult" type="Course">
        <id property="id" column="id"/>
        <result property="name" column="name"/>
        <result property="code" column="code"/>
        <collection property="studentsList" column="id" ofType="Student"
                    select="com.ssm.mapper.StudentMapper.findStudentById3">
        </collection>
    </resultMap>

    <select id="findCourseWithStudent2" parameterType="Integer" resultMap="CourseWithStudentResult2">
        select c.*, s.id as sid, s.name as sname, s.sex as ssex from tb_course c, tb_student s, tb_electiveCourse ec where ec.course_id = c.id and ec.student_id = s.id and c.id = #{id}
    </select>
    <resultMap id="CourseWithStudentResult2" type="Course">
        <id property="id" column="id"/>
        <result property="name" column="name"/>
        <result property="code" column="code"/>
        <collection property="studentsList" ofType="Student">
            <id property="id" column="sid"/>
            <result property="name" column="sname"/>
            <result property="sex" column="ssex"/>
        </collection>
    </resultMap>


    <select id="findCourseById" parameterType="Integer" resultType="Course">
        select * from tb_course where id in(
        select course_id from tb_electiveCourse where id = #{id}
        )
    </select>


</mapper>
```