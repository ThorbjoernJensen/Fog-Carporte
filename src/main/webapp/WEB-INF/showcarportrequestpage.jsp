<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Du er logget ind som ansat, og her kan du se en carport
        <table>
            <thead>
            <th>Carport ID</th>
            <th>Tag</th>
            <th>Højde</th>
            <th>Længde</th>
            <th>Bredde</th>
            <th>Skur</th>
            <th>Telefon</th>
            <th>Status</th>
            </thead>
            <c:forEach var="carports" items="${sessionScope.carportList}">
                <tr>
                    <td>${carports.carportId}</td>
                    <td>${carports.roofId}</td>
                    <td>${carports.height}</td>
                    <td>${carports.length}</td>
                    <td>${carports.width}</td>
                    <td>${carports.shedId}</td>
                    <td>${carports.tlf}</td>
                    <td>${carports.carportStatusId}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/fc/orderHandler" method="post">
                            <input class="btn btn-primary" type="submit" name="select" value="Godkend forespørgsel">
                            <input type="number" hidden id="carportId" name="carportId" value="${carports.carportId}">
                            <input type="number" hidden id="roofId" name="roofId" value="${carports.roofId}">
                            <input type="number" hidden id="height" name="height" value="${carports.height}">
                            <input type="number" hidden id="length" name="length" value="${carports.length}">
                            <input type="number" hidden id="width" name="width" value="${carports.width}">
                            <input type="number" hidden id="shedId" name="shedId" value="${carports.shedId}">
                            <input type="number" hidden id="tlf" name="tlf" value="${carports.tlf}">
                            <input type="number" hidden id="carportStatusId" name="carportStatusId" value="${carports.carportStatusId}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        se billede af carporten: <a href="${pageContext.request.contextPath}/fc/showsvg">SVG-tegning</a>


        <%--        <p>Den har disse data: </p>--%>
        <%--        <div class="container">--%>

        <%--            Carport-id: ${sessionScope.carport.carportId}<br>--%>
        <%--            Købers-id: ${sessionScope.carport.tlf}<br>--%>
        <%--            Længde: ${sessionScope.carport.length} cm<br>--%>
        <%--            Bredde: ${sessionScope.carport.width} cm<br>--%>
        <%--            Højde: ${sessionScope.carport.height} cm<br>--%>
        <%--            Skur-id: ${sessionScope.carport.shedId}<br>--%>
        <%--            Tag-id: ${sessionScope.carport.roofId}<br>--%>

        <%--        </div>--%>
        <%--        <h1>Stykliste</h1>--%>
        <%--        <div class="container">--%>
        <%--            Stolpe antal: ${sessionScope.bom.stolpe.stolpeAntal} stk<br>--%>
        <%--            Stolpe længde: ${sessionScope.bom.stolpe.stolpeLaengde} cm<br>--%>
        <%--            Stolpe pris: ${sessionScope.bom.stolpe.samletpris} kr. <br>--%>

        <%--            Remme antal: ${sessionScope.bom.rem.remAntal} stk<br>--%>
        <%--            Remme længde: ${sessionScope.bom.rem.remLaengde} cm<br>--%>
        <%--            Remme pris: ${sessionScope.bom.rem.samletpris} kr. <br>--%>

        <%--            Spær antal: ${sessionScope.bom.spær.spærAntal} stk<br>--%>
        <%--            Spær længde: ${sessionScope.bom.spær.spærLaengde} cm<br>--%>
        <%--            Max afstand mellem spærene: ${sessionScope.bom.spær.spærMaxAfstand} cm <br>--%>
        <%--            spær pris: ${sessionScope.bom.spær.samletpris} kr.<br>--%>

        <%--            Overstern antal: ${sessionScope.bom.overstern.oversternAntal} stk<br>--%>
        <%--            Overstern længde: ${sessionScope.bom.overstern.oversternLaengde} cm<br>--%>
        <%--            Overstern pris: ${sessionScope.bom.overstern.samletpris} <br>--%>
        <%--        </div>--%>
        <%--<br>--%>
        <%--<br>--%>
        <%--<br>--%>
        <%--       <h2> Samlet pris på carporten: ${sessionScope.bom.pris} </h2>--%>

        <%--        <form action="${pageContext.request.contextPath}/fc/orderHandler" method="post">--%>
        <%--            <input type="text" hidden id="carportId" name="carportId" value="${sessionScope.carport.carportId}"><br>--%>
        <%--            <input type="text" hidden id="tlf" name="tlf" value="${sessionScope.carport.tlf}"><br>--%>
        <%--            <input type="text" hidden id="price" name="price" value="${sessionScope.bom.pris}"><br>--%>
        <%--            <input type="submit" value="Godkend Ordre">--%>
        <%--        </form>--%>

    </jsp:body>
</t:genericpage>