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
        <%--        <h1>Velkommen ${sessionScope.email} </h1>--%>

        <h2>Velkommen ${sessionScope.user.name}. Her er et oversigt over dine muligheder </h2>
        <%--        You are now logged in as a Customer of our wonderful site.--%>
        <%--        Role: ${sessionScope.role}--%>

        <h2><a href="${pageContext.request.contextPath}/fc/viewrequestpage">Se dine bestillinger</a></h2>
        <h2><a href="${pageContext.request.contextPath}/fc/newrequestpage">Opret ny bestilling</a></h2>


    </jsp:body>

</t:genericpage>

