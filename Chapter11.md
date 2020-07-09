# Case1 a SpringMVC Applciation

## The flow
1. 前端控制器 DispatcherServlet 拦截 用户发送的 query 调用 HandlerMapping处理器映射器。
2. 处理器映射器 根据 url 找到对应的 具体处理器，生成处理器对象 和 处理器拦截器 返回给 DispatcherServlet。
3. DispatcherServlet 根据 返回信息 选择对应的 HandlerAdpter。
4. HandleAdapter 会调用执行 Handler， 例如书中的 Controller 类， 又称后段控制器。
5. Controller 处理完成后会返回 ModelAndView 对象。 该对象包含 视图名 或包含 模型与视图名。
6. HandlerAdapter 将ModelAndView 对象返回给 DispatcherServlet。
6. DispatcherServlet 会根据 返回的 ModelAndView 选择合适的 ViewResolver。
7. ViewResovler解释后， 返回给 DispatcherServlet 具体的 View。
8. DispatcherServlet 对 View 进行渲染。
9. 视图渲染结果会返回壳客户端浏览器。

所以开发人员子需要处理 DispatcherServlet， 完成 Controller 并在 view 中展示相应信息即可。

## DispatcherServlet
- 前端过滤器的配置
    - load-on-startup 在程序启动加载改servlet；不配置则在第一个servlet请求时加载。
    - init-param 子元素配置spring mvc文件的路径；不配置则在WEB-INF寻找对应命名配置文件。
## Controller注解
- @Contorller 
- 需要在 SpringMVC 配置引入 Spring-context
    - 使用 context:component-scan 扫描指定的类包。
## RequestMapping注解类型
- 用于映射一个请求和一个方法。
## ViewResolver
- 负责视图解析

