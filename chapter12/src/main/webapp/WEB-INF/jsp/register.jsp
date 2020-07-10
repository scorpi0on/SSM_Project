<%--
  Created by IntelliJ IDEA.
  User: scorpi09on
  Date: 2020/7/10
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/registerUser" method="post">
        用户名:<input type="text" name="username" />
        <br />
        密&nbsp;&nbsp;码:<input type="password" name="password" />
        <br />
        <button type="submit">Submit</button>
    </form>

</body>
</html>
