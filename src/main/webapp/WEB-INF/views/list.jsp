<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>

 	<h1><a href="<c:url value='/list' />">User Management App</a></h1>
 	
    <h2>List of Users</h2>  
    
    <a href="<c:url value='/create' />">Create a new User</a>
    
    <table>
        <tr>
            <td>UserId</td>
            <td>Username</td>
            <td>Firstname</td>
            <td>Lastname</td>
            <td>Date of birth</td>
            <td>Email</td>
            <td>Phone</td>
            <td>Mobile</td>
            <td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.userId}</td>
            <td>${user.username}</td>
            <td>${user.firstname}</td>
            <td>${user.lastnmae}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.mobile}</td>
            <td><a href="<c:url value='/user/edit/${user.userId}' />">Edit</a></td>
            <td><a href="<c:url value='/user/delete/${user.userId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</body>
</html>