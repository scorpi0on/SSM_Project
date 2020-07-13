# SpringMVC Data Binding

## Processing
1. SpringMVC 将 ServletRequest 对象传递给 Databinder。
2. 将处理的方法入参对象传递给 Databinder。
3. Databinder 调用 ConversionService 组件进行数据类型转换，数据格式化等工作，并将 ServletRequest 对象中的消息填充到参数对象中。
4. 调用 Validator 组件对已绑定了请求消息数据的参数对象进行数据合法性校验。
5. 校验完成后会生成数据绑定结果 BingdingResult 对象， SpringMVC 会将 BingdingResult 对象中的内容赋给处理方法的相应参数。

## 绑定简单数据类型

## 绑定POJO类型

## 绑定包装POJO

## 绑定数组

## 绑定集合