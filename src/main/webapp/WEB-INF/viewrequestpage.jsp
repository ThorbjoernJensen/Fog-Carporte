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
        <table>
        <thead>
        <th>Carport ID</th>
        <th>Tag</th>
        <th>Højde</th>
        <th>Længde</th>
        <th>Bredde</th>
        <th>Skur</th>
        <th>UserId</th>
        <th>Status</th>
        <th></th>
        <th></th>
        </thead>

        <c:forEach var="carports" items="${sessionScope.carportUserList}">
            <tr>
                <td>${carports.carportId}</td>
                <td>${carports.roofId}</td>
                <td>${carports.height}</td>
                <td>${carports.length}</td>
                <td>${carports.width}</td>
                <td>${carports.shedId}</td>
                <td>${carports.userId}</td>
                <td>${carports.carportStatusId}</td>
                <td>
                <form action="${pageContext.request.contextPath}/fc/orderHandlercustomer" method="post">
                    <input class="btn btn-primary" type="submit" name="select" value="Se carport tegning">
                    <input type="number" hidden id="carportId" name="carportId" value="${carports.carportId}">
                    <input type="number" hidden id="token" name="token" value="1">
                </form>
                </td>
                <td>
                <form action="${pageContext.request.contextPath}/fc/receiptpage" method="post">
                    <input class="btn btn-primary" type="submit" name="select" value="Slet ">
                    <input type="number" hidden id="carportId" name="carportId" value="${carports.carportId}">
                    <input type="number" hidden id="token" name="token" value="2">
                </form>
                </td>
            </tr>
        </c:forEach>
            </table>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

