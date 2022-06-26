<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <head>
        <title>Classes</title>
        <style type="text/css">
            <%@include file="../css/styles.css" %></style>
        </style>
    </head>

</head>

<body>
    <h2>Add / Edit class</h2>
    <form action="classes" method="post">
        <input type="hidden" name="classId" value="${class.classId}">
        <ul>
            <li>
                <label for="title">Title:</label>
                <input type="text" name="title" id="title" value="${class.title}">
            </li>
            <li>
                <label for="description">Description:</label>
                <input type="text" name="description" id="description" value="${class.description}">
            </li>
            <li>
                <input type="submit" value="Save">
            </li>
        </ul>
    </form>

    <h2>All CLasses</h2>
    <table>
        <thead>
            <tr>
                <th>№</th>
                <th>Title</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="cls" items="${listClasses}">
                <c:set var="count" value="${count + 1}" scope="page" />
                <tr>
                    <td>
                        <c:out value="${count}" />
                    </td>
                    <td>
                        <c:out value="${cls.title}" />
                    </td>
                    <td>
                        <c:out value="${cls.description}" />
                    </td>
                    <td>
                        <a href="/app/classes?editId=<c:out value='${cls.classId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/app/classes?deleteId=<c:out value='${cls.classId}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</html>