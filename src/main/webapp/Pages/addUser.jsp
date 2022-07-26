<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/4/2022
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .box{
            margin: 100px auto 100px auto;
            width: 300px;
        }
        body{
            background-color: lightslategrey;
        }
        .mylink{
            display: flex;
            justify-content: center;
            color: white;
            font-size: 24px;
            margin-top: 5rem;
        }
    </style>
</head>
<body>



<form  method="post" action="hello-servlet?page=register-new" class="box">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label"  >Username</label>
        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label" >FullName</label>
        <input type="text" class="form-control"  aria-describedby="emailHelp" name="fullname">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="pwd">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>



</form>




</body>
</html>
