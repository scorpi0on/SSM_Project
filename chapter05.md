# Spring Transaction management
## 核心接口 和 管理方式
  - PlatformTransitionManager
    > 提供平台事务管理器，提供了三个方法
      -  TransactionStatus getTransaction(TransactionDefinition definition)
      - void commit(TransactionStatus status)
      - void rollback(TransactionStatus status)
  - TransactionDefinition
    > 定义了事务规则，提供获取事务相关信息的方法。
  - TransactionStatus
    > 描述某一时间点上事务的状态信息 
  - 事务的管理方式
    - 编程式
    - 声明式

## 声明式事务管理
  - 提供 tx 命名空间来配置事务
  - 例子： 赠送积分
    - 流程：用户1收入积分->模拟系统运行时的突发性问题->用户2支持给用户1的积分
    - 事务管理可以防止在上诉突发性问题时候，用户1收到了积分而用户2没有支出积分
    - applicationContext配置(annotation)
      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:aop="http://www.springframework.org/schema/aop"
            xmlns:tx="http://www.springframework.org/schema/tx"
            xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
            http://www.springframework.org/schema/context  http://www.springframework.org/schema/context/spring-context.xsd
              http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
      <!--     1.配置数据源-->
          <bean id="dataSource"
                class="org.springframework.jdbc.datasource.DriverManagerDataSource" >
              <property name="driverClassName" value="com.mysql.jdbc.Driver" />
              <property name="url" value="jdbc:mysql://localhost:3306/db_spring?useSSL=false" />
              <property name="username" value="root" />
              <property name="password" value="1025" />
          </bean>
      <!--2.配置JDBC模板-->
          <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate" >
              <property name="dataSource" ref="dataSource" />
          </bean>
      <!--3.将JDBC注入UserDaoImpl-->
          <bean id="userDao" class="com.ssm.jdbc.UserDaoImpl">
              <property name="jdbcTemplate" ref="jdbcTemplate" />
          </bean>
      <!--4.事务管理器，依赖于数据源-->
          <bean id="transactionManager"
                class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
              <property name="dataSource" ref="dataSource" />
          </bean>
          <!--5.1编写通知：对事务进行增强，需要编写对切入点和具体执行事务细节-->
          <tx:annotation-driven transaction-manager="transactionManager" />
      <!--    &lt;!&ndash;5.2编写通知：对事务进行增强，需要编写对切入点和具体执行事务细节&ndash;&gt;-->
      <!--    <tx:advice id="txAdvice" transaction-manager="transactionManager">-->
      <!--        <tx:attributes>-->
      <!--            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT" read-only="false"/>-->
      <!--        </tx:attributes>-->
      <!--    </tx:advice>-->
      <!--&lt;!&ndash;6.编写aop，让spring自动对目标生产代理，需要使用AspectJ的表达式&ndash;&gt;-->
      <!--    <aop:config>-->
      <!--        <aop:pointcut expression="execution(* com.ssm.jdbc.*.*(..))" id="txPointCut"/>-->
      <!--        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut" />-->
      <!--    </aop:config>-->
      </beans>
  ```