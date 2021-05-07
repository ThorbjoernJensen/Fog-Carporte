<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Velkommen til Fogs Carporte</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Opret bestilling på din unikt tilpassede drømmecarport
            </div>


            <form action="${pageContext.request.contextPath}/fc/receiptpage" method="post">

                <h4>Vælg dimensioner på carporten</h4>
                <h5>vælg højde</h5>
                <select name="height" id="height">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                </select>

                <h5>vælg bredde</h5>
                <select name="width" id="width">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                </select>

                <h5>vælg længde</h5>
                <select name="length" id="length">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>

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
                <input type="submit" value="Send forespørgsel" class="btn btn-primary">

            </form>
            <c:if test="${sessionScope.error != null }">
                <p style="color:red">
                        ${sessionScope.error}
                </p>
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>