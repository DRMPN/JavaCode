<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Students</title>
        </head>

        <body>
            <h2>Add / Edit student</h2>
            <form action="students" method="post">
                <input type="hidden" name="student" value="${student.studentId}">
                First Name <input type="text" name="firstName" id="firstName" value="${student.firstName}"><br>
                Last Name <input type="text" name="lastName" id="lastName" value="${student.lastName}"><br>
                Age <input type="number" name="age" id="age" value="${student.age}"><br>
                Program <input type="text" name="program" id="age" value="${student.program}"><br>
                <input type="submit" value="Add/Edit Student">
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
                                <a href="/students?editId=<c:out value='${std.studentId}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/students?deleteId=<c:out value='${std.studentId}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>