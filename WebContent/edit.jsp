<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.um.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>USE MANAGEMANT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">USE MANAGEMANT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/List">User</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        <%
        User u=(User)request.getAttribute("us");
        
        %>
        <h1 align="center">USER DATA</h1>
        <form action="insert" method="post">
        
          <div class="mb-3">
      <label for="exampleformcontrolInput1" class="form-label">Name</label>
      <input type="text" class="form-control" id="exampleformcontrolInput1" value="<%=u.getName()%> " placeholder="Enter the name" name="name" style="width:300px">
    </div>
     <div class="mb-3">
      <label for="exampleformcontrolInput2" class="form-label">Email</label>
      <input type="text" class="form-control" id="exampleformcontrolInput2" value="<%=u.getEmail()%> " placeholder="Enter the email" name="email" style="width:300px">
    </div>
     <div class="mb-3">
      <label for="exampleformcontrolInput3" class="form-label">City</label>
      <input type="text" class="form-control" id="exampleformcontrolInput3" value="<%=u.getCity()%> "  placeholder="Enter the city" name="city" style="width:300px">
    </div>
    <div class="mb-3">
    <input type="submit" value="save" class="btn btn-success" style="width:150px"/>
    </div>
      </form> 
</body>
</html>