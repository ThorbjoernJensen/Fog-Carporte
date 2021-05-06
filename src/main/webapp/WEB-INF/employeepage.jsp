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
        You are now logged in as a EMPLOYEE of our wonderful site.
        <a href="${pageContext.request.contextPath}/fc/showcarportrequestpage">se en hardcoded carport-forespørgsel </a>
<%--        den skal med tiden sendes afsted med en carport-id, så siden kun viser detaljer for en given carport--%>

    </jsp:body>
</t:genericpage>
