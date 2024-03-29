<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h1>userTable.jsp</h1>
</head>
<body>
<div margin-left="auto" margin-right="auto">
    <form action="${pageContext.request.contextPath}/Update" method="POST">
        <input type="hidden" value="AddStart" name="EditType"/>
        <input type="submit" value="Add User">
    </form>
</div>
<table>
    <tr>
        <th>Id</th>
        <th>userName</th>
        <th>firstName</th>
        <th>secondName</th>
        <th>age</th>
        <th>Update user</th>
        <th>Delete user</th>
    </tr>

    <jsp:useBean id="lists" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${lists}">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUserName()}</td>
            <td>${user.getFirstName()}</td>
            <td>${user.getSecondName()}</td>
            <td>${user.getAge()}</td>

            <td>
                <form action="${pageContext.request.contextPath}/Update" method="POST">
                    <input type="hidden" value="${user.getId()}" name="id"/>
                    <input type="hidden" value="${user.getUserName()}" name="userName"/>
                    <input type="hidden" value="${user.getFirstName()}" name="firstName"/>
                    <input type="hidden" value="${user.getSecondName()}" name="secondName"/>
                    <input type="hidden" value="${user.getAge()}" name="age"/>
                    <input type="hidden" value="UpdateStart" name="EditType"/>
                    <input type="submit" value="Update">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/Update" method="POST">
                    <input type="hidden" value="Delete" name="EditType"/>
                    <input type="hidden" value="${user.getId()}" name="id"/>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
