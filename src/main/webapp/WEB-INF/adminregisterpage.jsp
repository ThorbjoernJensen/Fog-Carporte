<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register a new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="name">Kundens navn</label>
                    <div class="col-sm-4">
                        <input id="name" class="form-control" type="text" name="name" value="${param.name}"
                               placeholder="Skriv kundens navn">
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
                <input type="number" hidden id="tlf" name="tlf" value="${sessionScope.tlf}">
                <input type="number" hidden id="carportId" name="carportId" value="${sessionScope.carportId}">


                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


