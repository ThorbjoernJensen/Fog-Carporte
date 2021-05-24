<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
<%--         Home--%>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
<div class="container-fluid">
        <div>
            <h2 class="text-center">Velkommen til Fogs Carporte</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Opret bestilling på din unikt tilpassede drømmecarport
            </div>

            <form action="${pageContext.request.contextPath}/fc/registercommand" method="post">


                <h4>Vælg dimensioner på carporten</h4>
                <h5>vælg højde</h5>
                <select class="form-select" name="height" id="height">
                    <c:forEach var="height" items="${applicationScope.DimensionList}">
                        <option value="${height.height}">${height.height} cm</option>
                    </c:forEach>
                </select>

                <h5>vælg bredde</h5>
                <select class="form-select" name="width" id="width">
                    <c:forEach var="width" items="${applicationScope.DimensionList}">
                        <option value="${width.width}">${width.width} cm</option>
                    </c:forEach>
                </select>


                <h5>vælg længde</h5>
                <select class="form-select" name="length" id="length">
                    <c:forEach var="length" items="${applicationScope.DimensionList}">
                        <option value="${length.length}">${length.length} cm</option>
                    </c:forEach>
                </select>


                <h5>vælg tag</h5>
                <select name="roofmaterial" id="roofmaterial">
                    <option value="Plasttrapezplader">Plasttrapezplader</option>
                    <option value="Plasttrapezplader">Plasttrapezplader</option>
                </select>


                <div class="container">
                    <h4>Redskabsrum</h4>
                    <h5>vælg længde</h5>
                    <select name="shedlength" id="shedlength">
                        <option value="0" selected>Jeg ønsker ikke skur</option>
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                    </select>

                    <h5>vælg bredde</h5>
                    <select name="shedwidth" id="shedwidth">
                        <option value="0" selected>Jeg ønsker ikke skur</option>
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                    </select>
                </div>

        <br>
                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="name">Navn</label>
                            <div class="col-sm-4">
                                <input id="name" class="form-control" type="text" name="name" value="${param.name}"
                                       placeholder="Skriv dit navn">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="email">Email</label>
                            <div class="col-sm-4">
                                <input id="email" class="form-control" type="text" name="email" value="${param.email}"
                                       placeholder="Enter a valid email">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="tlf">Telefon</label>
                            <div class="col-sm-4">
                                <input id="tlf" class="form-control" type="number" name="tlf" value="${param.tlf}"
                                       placeholder="Enter a valid phone number">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="password1">Password</label>
                            <div class="col-sm-4">
                                <input id="password1" class="form-control" type="password" name="password1"
                                       value="${param.password1}" placeholder="Enter your password">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="password2">Password</label>
                            <div class="col-sm-4">
                                <input id="password2" class="form-control" type="password" name="password2"
                                       value="${param.password2}" placeholder="Repeat the password">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="address">Addresse</label>
                            <div class="col-sm-4">
                                <input id="address" class="form-control" type="text" name="address" value="${param.address}"
                                       placeholder="Skriv din addresse">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label class="col-sm-1 col-form-label" for="zip">PostNr</label>
                            <div class="col-sm-4">
                                <input id="zip" class="form-control" type="text" name="zip" value="${param.zip}"
                                       placeholder="Skriv dit postNr">
                            </div>
                        </div>

                        <input type="number" hidden id="creatorId" name="creatorId" value="1">

                <input type="submit" value="Send forespørgsel" class="btn btn-primary">

            </form>

            <c:if test="${sessionScope.error != null }">
                <p style="color:red">
                        ${sessionScope.error}
                </p>
            </c:if>
        </div>
</div>
    </jsp:body>
</t:genericpage>