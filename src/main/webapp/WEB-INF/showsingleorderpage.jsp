<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Ordre nr: ${requestScope.order.orderId}</title>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container-fluid pb-5 p-lg-3">
            <h3><p class="text-center">Enkelt ordre side</p></h3>
            <form action="${pageContext.request.contextPath}/fc/showsingleorder" method="post">
                <div class="row">
                    <div class="col-lg-12">
                            <table class="table">
                                <thead class="text-center">
                                <th>orderId</th>
                                <th>carportId</th>
                                <th>price</th>
                                <th>userId</th>
                                <th>materialList</th>
                                <th>orderDate</th>
                                <th>orderStatusId</th>
                                <th>rediger</th>
                                <th>slet</th>
                                <th></th>

                                </thead>

                                <tr class="text-center">
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
                                </tr>
                            </table>
                        </div>
                </div>
            </form>
        </div>

    </jsp:body>
</t:genericpage>
