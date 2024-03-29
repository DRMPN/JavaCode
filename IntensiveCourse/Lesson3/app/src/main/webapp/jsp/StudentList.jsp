<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!doctype html>
        <html lang="en">
        <%@include file="../jsp/head.jsp" %>

            <body>
                <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
                    <%@include file="../jsp/menu.jsp" %>

                        <main class="mdl-layout__content">
                            <div class="page-content">
                                <div class="mdl-grid center-items">
                                    <div class="mdl-cell mdl-cell--4-col">
                                        <div>
                                            <table
                                                class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                                                <thead>
                                                    <tr>
                                                        <th class="mdl-data-table__cell--non-numeric">NO</th>
                                                        <th>Last Name</th>
                                                        <th>First Name</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:set var="count" value="0" scope="page" />
                                                    <c:forEach var="student" items="${listStudent}">
                                                        <c:set var="count" value="${count + 1}" scope="page" />
                                                        <tr>
                                                            <td class="mdl-data-table__cell--non-numeric">
                                                                <c:out value="${count}" />
                                                            </td>
                                                            <td>
                                                                <c:out value="${student.lastName}" />
                                                            </td>
                                                            <td>
                                                                <c:out value="${student.firstName}" />
                                                            </td>
                                                            <td>
                                                                <a
                                                                    href="/students/edit?id=<c:out value='${student.id}' />">Edit</a>
                                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                                <a
                                                                    href="/students/delete?id=<c:out value='${student.id}' />">Delete</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                </div>
            </body>

        </html>