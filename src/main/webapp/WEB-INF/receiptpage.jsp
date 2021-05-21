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
            <h2>Her er din bestilling. Vores sælgere kigger på din ordre og vender tilbage snarest</h2>
            <div style="margin-top: 3em;margin-bottom: 3em;">
                <p>Du har valgt den magiske kombination: højde ${sessionScope.height} cm x, bredde ${sessionScope.width} cm og længde ${sessionScope.length} cm med ${sessionScope.roofmaterial}.</p>
                <c:if test="${sessionScope.shedlength !=null}">
                    <p> Du har valgt følgende dimensioner på dit skur:
                    ${sessionScope.shedlength} cm
                        ${sessionScope.shedwidth} cm
                    </p>
                </c:if>
                <p>
                    Held og lykke!
                </p>
            </div>


            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="${pageContext.request.contextPath}/fc/employeepage">Employee Page</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="${pageContext.request.contextPath}/fc/customerpage">Customer Page</a>
                </c:if>

        </div>

    </jsp:body>
</t:genericpage>