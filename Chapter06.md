# 初识MyBatis
> 一种持久化框架，一种ORM框架
> 比起Hibernate，适合复杂和需要优化性能的项目

## 用户查询操作步骤
1. 读取配置文件：mybatis-config.xml
2. 根据配置文件构建SqlSessionFactory
3. 通过SqlSessionFactory创建SqlSession
4. 使用SqlSession对象操作数据库
5. 关闭SqlSession

Chapter07将深入了解mybatis核心配置