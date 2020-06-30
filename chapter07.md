# MyBatis Core-setting

## SqlSessionFactory
    - 对象线程安全
    - 建议使用单例模式
## SqlSession
    - 是应用程序和持久层交互的操作的一个单线程对象
## Mybatis配置文件的元素
    - 根元素为<configuration>
    - 子元素必须由上到下顺序配置
### <properties>
    - 一个配置属性元素，通过外部配置来动态实现内部定义的属性
### <Setting>
    - 改变Mybatis运行时候的行为
### <typeAliases>
### <typeHandler>
### <objectFactor>    
### <plugins>
### <environments>
### <mappers

## 映射文件
### <select>
### <insert>
### <update> & <delete>
### <sql>
### <resultMap>