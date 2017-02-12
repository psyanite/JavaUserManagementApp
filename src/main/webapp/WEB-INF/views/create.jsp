<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create a new user</title>
 
	<style>
	    .error {
	        color: #ff0000;
	    }
	</style>
 
</head>
 
<body>
 	
 	<h1><a href="<c:url value='/list' />">User Management App</a></h1>
 
    <h2>Create a new user</h2>
  
    <form:form method="POST" modelAttribute="user">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="username">Username: </label> </td>
                <td><form:input path="username" id="username"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="firstname">Firstname: </label> </td>
                <td><form:input path="firstname" id="firstname"/></td>
                <td><form:errors path="firstname" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="lastname">Lastname: </label> </td>
                <td><form:input path="lastname" id="lastname"/></td>
                <td><form:errors path="lastname" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="dateOfBirth">Date of birth: </label> </td>
                <td><form:input path="dateOfBirth" id="dateOfBirth"/></td>
                <td><form:errors path="dateOfBirth" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="phone">Phone: </label> </td>
                <td><form:input path="phone" id="phone"/></td>
                <td><form:errors path="phone" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="mobile">Mobile: </label> </td>
                <td><form:input path="mobile" id="mobile"/></td>
                <td><form:errors path="mobile" cssClass="error"/></td>
            </tr>
     
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Create"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
</body>
</html>