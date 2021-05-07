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
        carport-id: ${sessionScope.carport.carportId}<br>
        længde: ${sessionScope.carport.length}<br>
        bredde: ${sessionScope.carport.width}<br>
        højde: ${sessionScope.carport.height}<br>
        skur-id: ${sessionScope.carport.shedId}<br>
        tag-id: ${sessionScope.carport.roofId}<br>

    </jsp:body>
</t:genericpage>