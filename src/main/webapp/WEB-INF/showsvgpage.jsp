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


            <h2>Velkommen til tegningen af carporten</h2>
        <p>her sætter vi en tegning</p>
<%--        ${requestScope.svgdrawing}--%>

        <svg xmlns="http://www.w3.org/2000/svg"
             xmlns:xlink="http://www.w3.org/1999/xlink"
             width="127" height="105" viewBox="0 0 255 210">

            <rect x="0" y="0" height="210" width="255"
                  style="stroke:#000000; fill: #FFFF00"/>
            <rect x="0" y="0" height="90" width="90"
                  style="stroke:#000000; fill: #0000FF"/>
            <rect x="120" y="0" height="90" width="135"
                  style="stroke:#000000; fill: #0000FF"/>
            <rect x="0" y="120" height="90" width="90"
                  style="stroke:#000000; fill: #0000FF"/>
            <rect x="120" y="120" height="90" width="135"
                  style="stroke:#000000; fill: #0000FF"/>
        </svg>

        ${requestScope.svg}





    </jsp:body>
</t:genericpage>