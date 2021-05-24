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
        <h2>Hej ${sessionScope.user.name}. </h2>
        <p> Her er en oversigt over dine aktive forespørgsler </p>


        <c:if test="${sessionScope.carportUserList.size()==0}">
        <p style="color:red">
            Du har ingen aktive forespørgsler
        </p>
        </c:if>

        <c:if test="${not empty sessionScope.carportUserList}">

        <table class="table">
        <thead>
        <th>Carport ID</th>
<%--        <th>Tag</th>--%>
        <th>Højde</th>
        <th>Længde</th>
        <th>Bredde</th>
<%--        <th>Skur</th>--%>
<%--        <th>UserId</th>--%>
        <th>Status</th>
        <th></th>
        <th></th>
        </thead>

        <c:forEach var="carports" items="${sessionScope.carportUserList}">
            <tr>
                <td>${carports.carportId}</td>
<%--                <td>${carports.roofId}</td>--%>
                <td>${carports.height}</td>
                <td>${carports.length}</td>
                <td>${carports.width}</td>
<%--                <td>${carports.shedId}</td>--%>
<%--                <td>${carports.userId}</td>--%>
                <td>${carports.carportStatusId}</td>
                <td>
                <form action="${pageContext.request.contextPath}/fc/orderHandler" method="post">
                    <input class="btn btn-primary" type="submit" name="select" value="Se carport tegning">
                </form>
                </td>
                <td>
                <form action="${pageContext.request.contextPath}/fc/orderHandler" method="post">
                    <input class="btn btn-primary" type="submit" name="select" value="Slet ">
                </form>
                </td>
            </tr>
        </c:forEach>
            </table>
        </c:if>

    </jsp:body>

</t:genericpage>

