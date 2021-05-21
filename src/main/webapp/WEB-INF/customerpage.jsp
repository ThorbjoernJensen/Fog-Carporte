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
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        Role: ${sessionScope.role}

       <h2><a href="${pageContext.request.contextPath}/fc/newrequestpage">Opret ny forespørgelse</a></h2>

       <h2><a href="${pageContext.request.contextPath}/fc/viewrequestpage">Se dine forespørgelser</a></h2>


    </jsp:body>

</t:genericpage>

