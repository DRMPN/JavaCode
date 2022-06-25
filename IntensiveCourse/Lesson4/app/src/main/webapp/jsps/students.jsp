<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Students</title>
        </head>

        <body>
            <h2>Students</h2>
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
                    <c:forEach var="student" items="${listStudent}">
                        <c:set var="count" value="${count + 1}" scope="page" />
                        <tr>
                            <td><c:out value="${count}"/></td>
                            <td><c:out value="${student.firstName}"/></td>
                            <td><c:out value="${student.lastName}"/></td>
                            <td><c:out value="${student.age}"/></td>
                            <td><c:out value="${student.program}"/></td>
                            <td>
                                <a href="/students/edit?id=<c:out value='${student.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/students/delete?id=<c:out value='${student.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>