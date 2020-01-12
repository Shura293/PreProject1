<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1>update.jsp</h1>
</head>
<body>
<table>
    <form action="${pageContext.request.contextPath}/Update" method="POST">

        <c:if test="${EditType == 'AddStart'}"><input type="hidden" name="EditType" value="AddEnd" /></c:if>
        <c:if test="${EditType == 'UpdateStart'}"><input type="hidden" name="EditType" value="UpdateEnd" /></c:if>

        <input type="hidden" name="id" value=${id} />
        <tr>
            <th>UserName</th> <td> <input type="text" name= "userName" value= ${userName} > </td>
        </tr>
        <tr>
            <th>FirstName</th> <td> <input type="text" name= "firstName" value= ${firstName} > </td>
        </tr>
        <tr>
            <th>SecondName</th> <td> <input type="text" name= "secondName" value= ${secondName} > </td>
        </tr>
        <tr>
            <th>Age</th> <td> <input type="text" name= "age" value= ${age} > </td>
        </tr>
        <tr>
            <td colspan="2">  <input type="submit" value="Action" /> </td>
        </tr>
    </form>///
</table>
</body>
</html>
