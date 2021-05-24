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
        <div class="container-fluid pb-5" style="background: rgb(12, 32, 105)">
            <div>
                <h2 style="color: aliceblue" class="text-center">Velkommen til Fogs Carporte</h2>


                <div style="margin-top: 3em;margin-bottom: 3em;">
                    <p style="color: aliceblue" class="text-center"> Opret bestilling på din unikt tilpassede drømmecarport</p>
                </div>

                <form action="${pageContext.request.contextPath}/fc/registercommand" method="post">

                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card" style="background: darkgrey">
                                            <div class="card-body">
                                                <h4 class="text-center">Vælg dimensioner på carporten</h4>
                                                <h5 class="text-center">vælg højde</h5>
                                                <select class="form-select" name="height" id="height">
                                                    <c:forEach var="height" items="${applicationScope.DimensionList}">
                                                        <option value="${height.height}">${height.height} cm</option>
                                                    </c:forEach>
                                                </select>

                                                <h5 class="text-center">vælg bredde</h5>
                                                <select class="form-select" name="width" id="width">
                                                    <c:forEach var="width" items="${applicationScope.DimensionList}">
                                                        <option value="${width.width}">${width.width} cm</option>
                                                    </c:forEach>
                                                </select>


                                                <h5 class="text-center">vælg længde</h5>
                                                <select class="form-select" name="length" id="length">
                                                    <c:forEach var="length" items="${applicationScope.DimensionList}">
                                                        <option value="${length.length}">${length.length} cm</option>
                                                    </c:forEach>
                                                </select>

                                                <h5 class="text-center">vælg tag</h5>
                                                <select class="form-select" name="roofmaterial" id="roofmaterial">
                                                    <option value="Plasttrapezplader">Plasttrapezplader</option>
                                                    <option value="Plasttrapezplader">Plasttrapezplader</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card mt-3" style="background: darkgrey">
                                            <div class="card-body">
                                                <h4 class="text-center">Redskabsrum</h4>
                                                <h5>vælg længde</h5>
                                                <select class="form-select" name="shedlength" id="shedlength">
                                                    <option value="0" selected>Jeg ønsker ikke skur</option>
                                                    <option value="10">10</option>
                                                    <option value="20">20</option>
                                                    <option value="30">30</option>
                                                </select>


                                                <h5>vælg bredde</h5>
                                                <select class="form-select" name="shedwidth" id="shedwidth">
                                                    <option value="0" selected>Jeg ønsker ikke skur</option>
                                                    <option value="10">10</option>
                                                    <option value="20">20</option>
                                                    <option value="30">30</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <br>
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card pb-3" style=" background: darkgray">
                                            <div class="card-body">
                                                <h4 class="text-center">Indtast brugeroplysninger</h4>
                                                <h5 class="text-center"><label for="name">Navn</label></h5>
                                                <input id="name" class="form-control" type="text" name="name"
                                                       value="${param.name}"
                                                       placeholder="Skriv dit navn">

                                                <h5 class="text-center"> <label for="email">Email</label></h5>
                                                <input id="email" class="form-control" type="text" name="email"
                                                       value="${param.email}"
                                                       placeholder="Enter a valid email">


                                                <h5 class="text-center"> <label for="tlf">Telefon</label> </h5>
                                                <input id="tlf" class="form-control" type="number" name="tlf"
                                                       value="${param.tlf}"
                                                       placeholder="Enter a valid phone number">


                                                <h5 class="text-center"> <label for="password1">Password</label></h5>
                                                <input id="password1" class="form-control" type="password"
                                                       name="password1"
                                                       value="${param.password1}" placeholder="Enter your password">


                                                <h5 class="text-center"> <label for="password2">Password</label></h5>
                                                <input id="password2" class="form-control" type="password"
                                                       name="password2"
                                                       value="${param.password2}" placeholder="Repeat the password">


                                                <h5 class="text-center"> <label for="address">Addresse</label></h5>

                                                 <input id="address" class="form-control" type="text" name="address"
                                                       value="${param.address}"
                                                       placeholder="Skriv din addresse">


                                                <h5 class="text-center"> <label for="zip">PostNr</label> </h5>

                                                 <input id="zip" class="form-control" type="text" name="zip"
                                                       value="${param.zip}"
                                                                                placeholder="Skriv dit postNr">


                                                <input type="number" hidden id="creatorId" name="creatorId" value="1">

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <input type="submit" value="Send forespørgsel" class="btn btn-primary mt-2">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

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