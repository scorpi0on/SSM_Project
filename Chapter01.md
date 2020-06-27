# The foundation of Spring

## IoC and DI

> IoC ，Inverse of Control，是 “控制反转”， 代表某对象需要的资源控制权从应用程序转移到IoC容器上。
> DI，Dependency Injext，是依赖注入，代表应用程序依赖容器创建并注入它所需要的资源。

优点：
- 可维护性
- 开发测试独立
- 可复用
- 热插拔
  
  ## 实现方式
  > IoC/DI框架提供两个核心容器，通过setter注入和构造方法注入实现。 核心容器：
  > - BeanFactory
  > - ApplicationFactory

![IoC 和 DI 的实现](/img/chapter01.png)
- 注意：书p8的applicationContext.xml里UserDao的id存在大小写不匹配问题
- java基础知识点：类的接口，重写，实现

