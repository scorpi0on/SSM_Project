<%--
  Created by IntelliJ IDEA.
  User: 42289
  Date: 2020/7/13
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESTful Testing</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script>
        function search(){
            var id = $("#number").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/customer/"+id,
                type:"GET",
                dataType:"json",
                success:function(data){
                    if (data.loginname != null){
                        alert("Customer loginname=" + data.loginname);
                    }else {
                        alert("Customer id=" + id + "doesn't exist.")
                    }
                }
            });
        }
    </script>
</head>
<body>
    <form>
        <input type="text" name="number" id="number" /><br/>
        <input type="button" value="Search" onclick="search()">
    </form>
</body>
</html>
