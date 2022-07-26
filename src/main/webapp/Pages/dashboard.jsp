<%@ page import="javax.swing.*" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/1/2022
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<jsp:include page="../include/navbar.jsp"></jsp:include>

<%--<%@ include file="../include/navbar.jsp" %>--%>


<%

    if(session != null){
        String fullName = (String) session.getAttribute("name");
        out.println("Welcome "+ fullName);

    }
%>




</body>
</html>
