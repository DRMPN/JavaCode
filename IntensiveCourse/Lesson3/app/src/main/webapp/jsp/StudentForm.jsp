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
                                        <div class="mdl-card mdl-shadow--6dp">
                                            <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                                                <h2 class="mdl-card__title-text">
                                                    <c:if test="${student != null}"> Edit Student </c:if>
                                                    <c:if test="${student == null}"> Add New Student </c:if>
                                                </h2>
                                            </div>
                                            <div class="mdl-card__supporting-text">
                                                <c:if test="${student != null}">
                                                    <form name="myForm" action="update" method="post"
                                                        onsubmit="return validateForm()">
                                                </c:if>
                                                <c:if test="${student == null}">
                                                    <form name="myForm" action="insert" method="post"
                                                        onsubmit="return validateForm()">
                                                </c:if>
                                                <c:if test="${student != null}">
                                                    <input type="hidden" name="id"
                                                        value="<c:out value='${student.id}' />" />
                                                </c:if>

                                                <div class="mdl-textfield mdl-js-textfield">
                                                    <input class="mdl-textfield__input" type="text" name="lastname"
                                                        value="<c:out value='${student.lastName}' />" id="lastname" />
                                                    <label class="mdl-textfield__label" for="lastname">Last Name</label>
                                                </div>

                                                <div class="mdl-textfield mdl-js-textfield">
                                                    <input class="mdl-textfield__input" type="text" name="firstname"
                                                        value="<c:out value='${student.firstName}' />" id="firstname" />
                                                    <label class="mdl-textfield__label" for="firstname">First
                                                        Name</label>
                                                </div>

                                                <input type="submit"
                                                    class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                                                    value="save">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                </div>
                <script type="text/javascript">
                    function validateForm() {
                        return true;
                    }
                </script>

            </body>

        </html>