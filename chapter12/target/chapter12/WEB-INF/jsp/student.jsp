<%--
  Created by IntelliJ IDEA.
  User: 42289
  Date: 2020/7/11
  Time: 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/findStudentWithBanji" method="post">
        学生编号：<input type="text" name="stu_id" />
        <br />
        所属班级： <input type="text" name="banji.banji_name" />
        <br />
        <button type="submit">Search </button>
    </form>
</body>
</html>
