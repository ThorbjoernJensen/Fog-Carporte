<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
<%--         Enkelt Ordre--%>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>


        <form action="${pageContext.request.contextPath}/fc/showsingleorder" method="post">

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
                <th></th>
                <th></th>

                </thead>

                <tr>
                    <td>${requestScope.order.orderId}</td>
                    <td>${requestScope.order.carportId}</td>
                    <td>${requestScope.order.price}</td>
                    <td>${requestScope.order.userId}</td>
                    <td>${requestScope.order.materialList}</td>
                    <td>${requestScope.order.orderDate}</td>
                    <td>${requestScope.order.orderStatusId}</td>
                    <td>
                        <button class="btn btn-primary " type="submit" name="editOrder"
                                value="${requestScope.order.orderId}">Rediger
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger " type="submit" name="cancel"
                                value="${requestScope.order.orderId}">!Slet!
                        </button>
                    <td>
                        Se billede af carporten: <a href="${pageContext.request.contextPath}/fc/showsvg"></a>
                </td>
                </tr>
            </table>
        </form>


    </jsp:body>
</t:genericpage>
