# Spring AOP

## What is AOP
> 面向切面编程，通过Aspect可以分别在不同类的方法中加入事务，日志，权限和异常等功能。

## AspectJ开发
> - 基于XML
> ![chapter03_XmlAspectJ](/img/chapter03_XmlAspectJ.png)
> 
> - 基于注解
 > ![chapter03_AnnotationAspectJ](/img/chapter03_AnnotationAspectJ.png)
- 注意：
  -  <aop:pointcut>属于<aop:config>子元素时候为全局切入点；属于<aop:aspect>时候，只对该切入点有效; 
  -  xml配置声明时候publicID和SystemId成对存在，不能调换次序；
  -  同一个连接点有多个通知执行，那么对于同一个切面中，环绕与前后通知的执行顺序是未知的；


- 补充：
  - AOP核心概念
    - 切面： 对于拦截对象处理方法的抽象。
    - 连接点：是被拦截到的方法，字段，构造器
    - 切入点：对连接点进行拦截的定义
    - 通知：即拦截到连接点后要执行的代码
    - 目标对象：代理的目标对象
    - 织入：将切面应用到目标对象并导致代理对象创建的过程
    - 引入：在不修改代码的前提下，引入可以在运行期间为类动态地添加一些方法或字段