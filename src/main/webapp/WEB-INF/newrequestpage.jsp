<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        Role: ${sessionScope.role}

        <h2>Opret ny forespørgelse</h2>
        <form action="${pageContext.request.contextPath}/fc/receiptpage" method="post">

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
            <input type="number" hidden id="token" name="token" value="3">
            <input type="submit" value="Send forespørgsel" class="btn btn-primary">
        </form>

    </jsp:body>

</t:genericpage>

