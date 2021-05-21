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
        <H2>Du har godkendt følgende ordre</H2>
        Den har fået følgende ordre ID:
        ${requestScope.orderId}

<br>
<br>
        se billede af carporten: <a href="${pageContext.request.contextPath}/fc/showsvg">SVG-tegning</a>
        <div class="container">
        Carport-id: ${sessionScope.carport.carportId}<br>
        Længde: ${sessionScope.carport.length} cm<br>
        Bredde: ${sessionScope.carport.width} cm<br>
        Højde: ${sessionScope.carport.height} cm<br>
        Skur-id: ${sessionScope.carport.shedId}<br>
        Tag-id: ${sessionScope.carport.roofId}<br>

        </div>
        <h1>Stykliste</h1>
        <div class="container">
        Stolpe antal: ${sessionScope.bom.stolpe.stolpeAntal} stk<br>
        Stolpe længde: ${sessionScope.bom.stolpe.stolpeLaengde} cm<br>
        Stolpe pris: ${sessionScope.bom.stolpe.samletpris} kr. <br>

        Remme antal: ${sessionScope.bom.rem.remAntal} stk<br>
        Remme længde: ${sessionScope.bom.rem.remLaengde} cm<br>
        Remme pris: ${sessionScope.bom.rem.samletpris} kr. <br>

        Spær antal: ${sessionScope.bom.spær.spærAntal} stk<br>
        Spær længde: ${sessionScope.bom.spær.spærLaengde} cm<br>
        Max afstand mellem spærene: ${sessionScope.bom.spær.spærMaxAfstand} cm <br>
        spær pris: ${sessionScope.bom.spær.samletPris} kr.<br>

        Overstern antal: ${sessionScope.bom.overstern.oversternAntal} stk<br>
        Overstern længde: ${sessionScope.bom.overstern.oversternLaengde} cm<br>
        Overstern pris: ${sessionScope.bom.overstern.samletpris} <br>
        </div>


        <h4>Samlet pris før evt rabatter: ${sessionScope.bom.pris}</h4>

        <h4>Samlet pris efter evt rabatter: ${sessionScope.newPrice}</h4>

                <form action="${pageContext.request.contextPath}/fc/updatePrice" method="post">

                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label" for="price">Ændre pris for ordre</label>
                <div class="col-sm-3">
                    <input id="price" class="form-control" type="number" step="0.01" name="price" value="Ændre pris:">
                </div>
                    </div>

                    <input type="number" hidden id="orderId" name="orderId" value="${sessionScope.orderId}">
                    
                    <input type="submit" value="Ændre pris" class="btn btn-primary">
                </form>

        <form action="${pageContext.request.contextPath}/fc/orderHandler" method="post">

            <input class="btn btn-primary" type="submit" name="select" value="Godkend ordre">
            <input type="number" hidden id="carportId" name="carportId" value="${sessionScope.carport.carportId}">
            <input type="number" hidden id="roofId" name="roofId" value="${sessionScope.carport.roofId}">
            <input type="number" hidden id="height" name="height" value="${sessionScope.carport.height}">
            <input type="number" hidden id="length" name="length" value="${sessionScope.carport.length}">
            <input type="number" hidden id="width" name="width" value="${sessionScope.carport.width}">
            <input type="number" hidden id="shedId" name="shedId" value="${sessionScope.carport.shedId}">
            <input type="number" hidden id="userId" name="userId" value="${sessionScope.carport.userId}">
            <input type="number" hidden id="carportStatusId" name="carportStatusId" value="${sessionScope.carport.carportStatusId}">
            <input type="text" hidden id="token" name="token" value="5">
            <input type="text" hidden id="newPrice" name="newPrice" value="${0}">

        </form>

<%--        <form action="${pageContext.request.contextPath}/fc/updatePrice" method="post">--%>

<%--            <div class="row mb-3">--%>
<%--                <label class="col-sm-2 col-form-label" for="price">Ændre pris for ordre</label>--%>
<%--        <div class="col-sm-3">--%>
<%--            <input id="price" class="form-control" type="number" step="0.01" name="price" value="Ændre pris:">--%>
<%--        </div>--%>
<%--            </div>--%>

<%--            <input type="number" hidden id="orderId" name="orderId" value="${sessionScope.orderId}">--%>
<%--            <input type="number" hidden id="carportId" name="carportId" value="${sessionScope.carport.carportId}">--%>

<%--            <input type="submit" value="Ændre pris" class="btn btn-primary">--%>
<%--        </form>--%>

    </jsp:body>
</t:genericpage>