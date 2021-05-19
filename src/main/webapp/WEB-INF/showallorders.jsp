<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Her er en liste af alle ordre
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>



        <form action="${pageContext.request.contextPath}/fc/showOrders" method="post">

        <table class="table">
        <thead>
        <th>orderId</th>
        <th>carportId</th>
        <th>price</th>
        <th>userId</th>
        <th>materialList</th>
        <th>orderDate</th>
        <th>orderStatusId</th>
        <th></th>
        </thead>

        <c:forEach var="order" items="${applicationScope.orderList}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.carportId}</td>
                <td>${order.price}</td>
                <td>${order.userId}</td>
                <td>${order.materialList}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderStatusId}</td>
                <td>
<%--                    <button class="btn btn-danger " type="submit" name="delete"--%>
<%--                            value="${userItem.id}">slet kunde!--%>
<%--                    </button>--%>
                </td>
            </form>

        </c:forEach>


    </jsp:body>
</t:genericpage>
