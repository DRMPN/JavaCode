<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>
         
        <head>
            <title>Students</title>
            <style type="text/css">
                <%@include file="../css/styles.css" %>
            </style>
        </head>

        <body>
            <h2>Add / Edit student</h2>
            <form action="students" method="post">
                <input type="hidden" name="studentId" value="${student.studentId}">
                <ul>
                    <li>
                        <label for="firstName">First Name:</label>
                        <input type="text" name="firstName" id="firstName" value="${student.firstName}">
                    </li>
                    <li>
                        <label for="lastName">Last Name:</label>
                        <input type="text" name="lastName" id="lastName" value="${student.lastName}">
                    </li>
                    <li>
                        <label for="age">Age:</label>
                        <input type="number" name="age" id="age" value="${student.age}">
                    </li>
                    <li>
                        <label for="program">Program:</label>
                        <input type="text" name="program" id="program" value="${student.program}">
                    </li>
                    <li>
                        <input type="submit" value="Save">
                    </li>
                </ul>
            </form>

            <h2>All Students</h2>
            <table>
                <thead>
                    <tr>
                        <th>№</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                        <th>Program</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach var="std" items="${listStudent}">
                        <c:set var="count" value="${count + 1}" scope="page" />
                        <tr>
                            <td>
                                <c:out value="${count}" />
                            </td>
                            <td>
                                <c:out value="${std.firstName}" />
                            </td>
                            <td>
                                <c:out value="${std.lastName}" />
                            </td>
                            <td>
                                <c:out value="${std.age}" />
                            </td>
                            <td>
                                <c:out value="${std.program}" />
                            </td>
                            <td>
                                <a href="/app/students?editId=<c:out value='${std.studentId}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/app/students?deleteId=<c:out value='${std.studentId}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>