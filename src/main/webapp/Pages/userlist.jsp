<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/3/2022
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Lists</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<%--<jsp:include page="../include/navbar.jsp"/>--%>

<%@ include file="../include/navbar.jsp" %>


<h1>
    List of Users
</h1>

<a href="hello-servlet?page=addUser"> Add New User</a>

<table class="table table-striped">
    <thead>

    <tr>
        <th scope="col">Id</th>
        <th scope="col">Username</th>
        <th scope="col">FullName </th>
        <th scope="col">Password</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="usr">
    <tr>

        <td> ${usr.id} </td>
        <td>
            <p> ${usr.username}</p>
        </td>
        <td>
            <p> ${usr.fullName}</p>
        </td>
        <td>
            <p> ${usr.pwd}</p>
        </td>

        <td>
            <a href="hello-servlet?page=userDetails&id=${usr.id}">User Details</a>
        </td>

    </tr>
    </c:forEach>
    </tbody>

</table>


</body>
</html>
