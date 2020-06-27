# Bean in Spring

## Bean配置
> 最常采用xml的文件方式配置beam的属性。
需要记住常见属性和子元素

## Bean的作用域

### Singleton
> singleton是spring容器默认的作用域，共享一个bean实例。
> ![singleton](/img/chapter02_singleton.png)

补充：单例实现由饿汉模式和懒汉模式。懒汉模式需要使用synchronized和volatile设计双重检验锁解决并发问题。或者使用静态内部类的单例模式。singletonObjects和concurrentHashmap。
### Prototype
> 对需要保持会话状态的bean应用使用prototype作用域，对每个该bean的请求都会创建一个新实。
> ![prototype](/img/chapter02_prototype.png)

## Bean的装配方式/依赖注入方式
> - 基于XML的装配：默认构造实例化bean对象，反射调用setter注入。因此要求bean类提供默认无参构造方法，以及注入属性对应的setter方法。
> ![XmlAssemble](/img/chapter02_XmlAssemble.png)
> - 基于Annotation的装配：常用 @Repository("123"), @Resource(name = "123"), @Service("123"), @Controller("123")
> ![AnnotationAssemble](/img/chapter02_AnnotationAssemble.png)
> - 自动装配
> ![AutoAssemble](/img/chapter02_AutoAssemble.png)

Java基础知识：构造器, super(), setter()
- 补充Spring内的常见设计模式：
  - 单例模式
    - Singleton
  - 简单工厂模式
    - Factory(包含判断逻辑) -> ConcreteProduct(抽象类的实现) -> Product(抽象类)
    - 优点
        - 实现对象创建和使用分离，无需创建具体产品类的类名
    - 缺点
      - 负责全部创建逻辑，责任过重
      - 增加类个数，增加系统复杂性和理解难度
      - 工厂角色无法形成基于基础的等级结构
  - 工厂方法模式
    - 解决简单工厂模式缺点的方法：让类的实例化延迟到其子类，其提供接口。
  - 动态代理模式

