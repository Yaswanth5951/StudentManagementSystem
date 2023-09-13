<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
     <%@ page import="com.um.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">STUDENT MANAGEMANT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href=<%=request.getContextPath() %>/List>User</a>
        </li>
        </ul>
        </div>
        </div>
        </nav>
        <h1 style="color:blue" aline="center"><center>STUDENT MANAGEMENT SYSTEM</center></h1>
        <hr></hr>
        <br>
        <div class="container">
        <a href="<%=request.getContextPath()%>/add"class="btn btn-success">ADD USER</a>
        <br><br>
        <table class="table" table-striped">
        <thead>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>CITY</th>
        <th>ACTIONS</th>
        </thead>
        <tbody>
        <%ArrayList<User> a1=(ArrayList<User>)request.getAttribute("display");%>
        <%for(User u:a1)
        {
         %>
         <tr>
         <td><%=u.getId() %></td>
         <td><%=u.getName() %></td>
         <td><%=u.getEmail()%></td>
         <td><%=u.getCity()%></td>
         <td><a href="<%=request.getContextPath()%>/edit?id=<%=u.getId()%>">EDIT</a>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/delete?id=<%=u.getId()%>">DELETE</a></td>
         </tr>
        <%
        }%>
        </tbody>
        </table>
        </div>
</body>
</html>