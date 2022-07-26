<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    .box{
        margin: 100px auto 100px auto;
        width: 300px;
    }
    body{
        background-color: darkseagreen;
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

<h1>This is MY Register Page</h1>


<form  method="post" action="hello-servlet?page=register" class="box">
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


    <a href="hello-servlet?page=old-user" class="mylink mb-5">Login Page</a>


</form>




</body>
</html>