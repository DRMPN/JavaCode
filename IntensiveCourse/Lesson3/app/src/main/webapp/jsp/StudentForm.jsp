<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!doctype html>
        <html lang="en">
        <%@include file="../jsp/head.jsp" %>

            <body>
                <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
                    <%@include file="../jsp/menu.jsp" %>
                        <main class="mdl-layout__content">
                            <div class="mdl-card mdl-shadow--6dp">
                                <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                                    <h2 class="mdl-card__title-text">CRUD app</h2>
                                </div>
                                <div class="mdl-card__supporting-text">
                                    <form action="form" method="post">

                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input class="mdl-textfield__input" type="text" id="lastname"
                                                name="lastname" />
                                            <label class="mdl-textfield__label" for="lastname">Last Name</label>
                                        </div>

                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input class="mdl-textfield__input" type="text" id="firstname"
                                                name="firstname" />
                                            <label class="mdl-textfield__label" for="firstname">First Name</label>
                                        </div>

                                        <button
                                            class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Save</button>

                                </div>
                                </form>
                            </div>

                </div>
                </main>
                </div>

            </body>

        </html>