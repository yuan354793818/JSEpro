<%--
  Created by IntelliJ IDEA.
  User: YJY
  Date: 2019/1/25
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="hacksys.JavaClassExecuter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>
<% InputStream is = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\web-test\\target\\classes\\com\\test\\Main.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();
%>
<%=JavaClassExecuter.execute(b)%>
<%=JavaClassExecuter.class.getClassLoader().getParent()%>
</body>
</html>
