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
        <p>Den har disse data: </p>
        Carport-id: ${sessionScope.carport.carportId}<br>
        Længde: ${sessionScope.carport.length} cm<br>
        Bredde: ${sessionScope.carport.width} cm<br>
        Højde: ${sessionScope.carport.height} cm<br>
        Skur-id: ${sessionScope.carport.shedId}<br>
        Tag-id: ${sessionScope.carport.roofId}<br>

        <h1>Stykliste</h1>
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

    </jsp:body>
</t:genericpage>