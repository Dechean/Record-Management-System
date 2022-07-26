
<!DOCTYPE html>
<html>
<head>
  <title>Register Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<%@ include file="../include/navbar.jsp" %>


<h1>This is MY Edit Page</h1>


<form  method="post" action="hello-servlet?page=edit" class="box">

  <input type="hidden" name="id"  value="${myUser.id}">

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label"  >Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" value="${myUser.username}">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >FullName</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" name="fullname" value="${myUser.fullName}">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="pwd" value="${myUser.pwd}">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>


</form>




</body>
</html>