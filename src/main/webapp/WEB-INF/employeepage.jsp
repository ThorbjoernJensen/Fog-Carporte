<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Employee Page</title>
<t:genericpage>
    <jsp:attribute name="header">
<%--         Demo Page for Employee Roles--%>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container-fluid rounded pb-5" style="background: rgb(12, 32, 105)">
            <p class="text-center" style="color: aliceblue">You are now logged in as a EMPLOYEE of our wonderful
                site.</p>

                    <a STYLE="color: aliceblue" type="button" class="btn bg-primary"
                       href="${pageContext.request.contextPath}/fc/showcarportrequestpage">Se ordrerforespørgsler</a>
                    <a STYLE="color: aliceblue" type="button" class="btn bg-primary"
                     href="${pageContext.request.contextPath}/fc/showOrders"> se alle ordre </a>

                </div>


    </jsp:body>
</t:genericpage>
