<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Customerpage</title>
<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h2>Velkommen ${sessionScope.user.name}. </h2>
        <p> Her er en oversigt over dine muligheder: </p>
        <p><a href="${pageContext.request.contextPath}/fc/viewrequestpage">Se bestillinger </a></p>
        <p><a href="${pageContext.request.contextPath}/fc/newrequestpage">Opret ny bestilling</a></p>
    </jsp:body>

</t:genericpage>

