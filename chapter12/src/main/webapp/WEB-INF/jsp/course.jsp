<%--
  Created by IntelliJ IDEA.
  User: 42289
  Date: 2020/7/11
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程列表</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/deleteCourse" method="post">
        <table>
            <tr>
                <tr>选择</tr>
                <tr>课程名字</tr>
            </tr>
            <tr>
                <td><input name="ids" value="1" type="checkbox"></td>
                <td>JAVA程序设计</td>
            </tr>            <tr>
                <td><input name="ids" value="2" type="checkbox"></td>
                <td>数据库</td>
            </tr>            <tr>
                <td><input name="ids" value="3" type="checkbox"></td>
                <td>JavaEE应用开发</td>
            </tr>
        </table>
        <button type="submit">删除</button>
    </form>

</body>
</html>
