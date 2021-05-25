<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Dine forespørgsler</title>

<t:genericpage>
    <jsp:attribute name="header">

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
        </c:if>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

