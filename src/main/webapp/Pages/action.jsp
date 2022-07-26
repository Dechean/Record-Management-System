<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/3/2022
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Action</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <style>

        .links{
            padding: 5px;
        }


    </style>

</head>
<body>

<%@ include file="../include/navbar.jsp" %>


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

        <tr>

            <td> ${myUser.id} </td>
            <td>
                <p> ${myUser.username}</p>
            </td>
            <td>
                <p> ${myUser.fullName}</p>
            </td>
            <td>
                <p> ${myUser.pwd}</p>
            </td>

            <td>

                <a href="hello-servlet?page=editUser&id=${myUser.id}" class="links"> Edit </a>

                <a href="hello-servlet?page=deleteUser&id=${myUser.id}" class="links"> Delete </a>



            </td>

        </tr>

    </tbody>

</table>





</body>
</html>



