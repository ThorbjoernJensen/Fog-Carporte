<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Bestillinger</title>
<t:genericpage>

    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Tak for din henvendelse. </h2>
            <div style="margin-top: 3em;margin-bottom: 3em;">
                <p>Du har valgt følgende mål: højde ${sessionScope.height} cm x, bredde ${sessionScope.width} cm og
                    længde ${sessionScope.length} cm. Som tagbeklædning er valgt: ${sessionScope.roofmaterial}.</p>

                <c:if test="${sessionScope.shedlength !=null}">
                    <p> Du har valgt følgende dimensioner på dit skur:
                            ${sessionScope.shedlength} cm
                            ${sessionScope.shedwidth} cm
                    </p>
                </c:if>
                <p> Vores sælgere kigger på din bestilling og vender tilbage snarest!

                </p>
            </div>

        </div>

    </jsp:body>
</t:genericpage>