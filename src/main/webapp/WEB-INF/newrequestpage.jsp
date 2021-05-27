<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Opret forespørgelse</title>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <form action="${pageContext.request.contextPath}/fc/receiptpage" method="post">

            <h4>Vælg dimensioner på carporten</h4>
            <h5>Højde</h5>
            <select class="form-select" name="height" id="height">
                <c:forEach var="height" items="${applicationScope.DimensionList}">
                    <option value="${height.height}">${height.height} cm</option>
                </c:forEach>
            </select>

            <h5>Bredde</h5>
            <select class="form-select" name="width" id="width">
                <c:forEach var="width" items="${applicationScope.DimensionList}">
                    <option value="${width.width}">${width.width} cm</option>
                </c:forEach>
            </select>

            <h5>Længde</h5>
            <select class="form-select" name="length" id="length">
                <c:forEach var="length" items="${applicationScope.DimensionList}">
                    <option value="${length.length}">${length.length} cm</option>
                </c:forEach>
            </select>

            <h5>Tagbeklædning</h5>
            <select name="roofmaterial" id="roofmaterial">
                <option value="Plasttrapezplader">Plasttrapezplader</option>
                <option value="Plasttrapezplader">Plasttrapezplader</option>
            </select>

            <div class="container">
                <h4>Redskabsrum</h4>
                <h5>Længde</h5>
                <select name="shedlength" id="shedlength">
                    <option value="0" selected>Jeg ønsker ikke skur</option>
<%--                    <option value="10">10</option>--%>
<%--                    <option value="20">20</option>--%>
<%--                    <option value="30">30</option>--%>
                </select>

                <h5>Bredde</h5>
                <select name="shedwidth" id="shedwidth">
                    <option value="0" selected>Jeg ønsker ikke skur</option>
<%--                    <option value="10">10</option>--%>
<%--                    <option value="20">20</option>--%>
<%--                    <option value="30">30</option>--%>
                </select>
            </div>

            <input type="number" hidden id="token" name="token" value="3">
            <input type="submit" value="Send forespørgsel" class="btn btn-primary mt-3">
        </form>

    </jsp:body>

</t:genericpage>

