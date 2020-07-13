<%--
  Created by IntelliJ IDEA.
  User: 42289
  Date: 2020/7/12
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/editUsers" method="post" >
        <table>
            <tr>
                <td>选择</td>
                <td>用户名</td>
            </tr>
            <tr>
                <td><input name="users[0].id" value="1" type="checkbox"></td>
                <td><input  name="users[0].username" value="zhangsan" type="text"></td>
            </tr>
            <tr>
                <td><input name="users[1].id" value="2" type="checkbox"></td>
                <td><input  name="users[1].username" value="lisi" type="text"></td>
            </tr>
        </table>
        <button type="submit">Update</button>
    </form>

</body>
</html>
