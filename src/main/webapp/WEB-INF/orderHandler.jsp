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
        ${sessionScope.orderId}

<br>
<br>

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
        spær pris: ${sessionScope.bom.spær.samletpris} kr.<br>

        Overstern antal: ${sessionScope.bom.overstern.oversternAntal} stk<br>
        Overstern længde: ${sessionScope.bom.overstern.oversternLaengde} cm<br>
        Overstern pris: ${sessionScope.bom.overstern.samletpris} <br>
        </div>


        <h4>Samlet pris før evt rabatter: ${sessionScope.bom.pris}</h4>

        <form action="${pageContext.request.contextPath}/fc/updatePrice" method="post">

            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="price">Ændre pris for ordre</label>
        <div class="col-sm-4">
            <input id="price" class="form-control" type="number" name="price" value="Ændre pris:"
                   placeholder="${sessionScope.bom.pris}">
        </div>
            </div>

            <input type="number" hidden id="orderId" name="orderId" value="${sessionScope.orderId}">
            <input type="number" hidden id="carportId" name="carportId" value="${sessionScope.carport.carportId}">

            <input type="submit" value="Ændre pris" class="btn btn-primary">
        </form>

    </jsp:body>
</t:genericpage>