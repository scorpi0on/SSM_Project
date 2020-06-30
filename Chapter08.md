# Dynamic SQL
> 提供对SQL语句动态组装的功能，避免手动拼装SQL。

## if元素
```xml
<!--只有当test条件为true时候执行里面的语句-->
        <if test="username != null and username != ''">
            and username like concat('%', #{username}, '%')
        </if>
        <if test="jobs != null and jobs != ''">
            and jobs = #{jobs}
        </if>
    </select>
```
## choose&when&otherwise元素
> 复杂情况下，选<choose>方法。类似java里的sitch...case...default
```xml
<!--<choose>(<when><otherwise>)元素的使用-->
    <select id="findUserByNameOrJobs" parameterType="com.ssm.po.User" resultType="com.ssm.po.User">
        select * from t_user where 1=1
        <choose>
            <when test="username != null and username !=''">
                and username like concat('%',#{username},'%')
            </when>
            <when test="jobs != null and jobs != ''">
                and jobs = #{jobs}
            </when>
            <otherwise>
                and phone is not null
            </otherwise>
        </choose>
    </select>
```
## where&trim元素
> 避免使用 where 1=1。
```xml
<!--    只有当test条件为true时候执行里面的语句-->
    <select id="findUserByNameAndJobs" parameterType="Integer" resultType="com.ssm.po.User">
        select * from t_user
        <where>
            <if test="username != null and username != ''">
                and username like concat('%', #{username}, '%')
            </if>
            <if test="jobs != null and jobs != ''">
                and jobs = #{jobs}
            </if>
        </where>

    </select>
<!--<choose>(<when><otherwise>)元素的使用-->
    <select id="findUserByNameOrJobs" parameterType="com.ssm.po.User" resultType="com.ssm.po.User">
        select * from t_user
        <trim prefix="where" prefixOverrides="and">
            <choose>
                <when test="username != null and username !=''">
                    and username like concat('%',#{username},'%')
                </when>
                <when test="jobs != null and jobs != ''">
                    and jobs = #{jobs}
                </when>
                <otherwise>
                    and phone is not null
                </otherwise>
            </choose>
        </trim>
    </select>
    ```
## set元素
> 更新对象内容，只更新有需要的部分。<set><if>组合使用，如果传入值都为空，则报错。
```xml
<!--更新用户-->
    <update id="updateUser" parameterType="com.ssm.po.User">
        update t_user
        <set>
            <if test="username != null and username != ''">
                username=#{username},
            </if>
            <if test="jobs != null and jobs != ''">
                jobs=#{jobs},
            </if>
            <if test="phone != null and phone != ''">
                phone=#{phone},
            </if>
        </set>
        where id=#{id}
    </update>
```
## foreach元素
> mybatis提供的数组集合循环遍历方式。
```xml
    <!--根据用户编号s获取信息-->
    <select id="findUserByIds" parameterType="List" resultType="com.ssm.po.User">
        select * from t_user where id in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </select>
```
## bind元素
> 进行模糊查询编写SQL时候，使用${}进行字符串拼接，则无法防止SQL注入问题。MySQL和Oracle的连接方式不同，分别为concat函数和 ||。
```xml
<!--使用bind-->
    <select id="findUserByName2" parameterType="com.ssm.po.User" resultType="com.ssm.po.User">
        <bind name="p_username" value="'%'+ _parameter.getUsername + '%'"/>
        select * from t_user where username like #{p_username}
    </select>
```