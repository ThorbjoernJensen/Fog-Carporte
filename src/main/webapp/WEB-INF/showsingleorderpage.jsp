<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Enkelt Ordre
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
                        <button class="btn btn-danger " type="submit" name="editOrder"
                                value="${requestScope.order.orderId}">Rediger
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger " type="submit" name="cancel"
                                value="${requestScope.order.orderId}">Annuller
                        </button>
                    </td>
                </tr>
            </table>
        </form>


        <%--        <form action="${pageContext.request.contextPath}/fc/managesports" method="post">--%>
        <%--            <input type="hidden" name="sports_id" value="${requestScope.sportItem.sport_id}"/>--%>
        <%--            <div class="input-group input-group-sm mb-3">--%>
        <%--                <div class="form-group">--%>
        <%--                    <label class="form-check-label" for="name">Navn: </label>--%>
        <%--                    <input id="name" class="form-control" type="text" name="name"--%>
        <%--                           value="${requestScope.sportItem.name}"/>--%>
        <%--                    <button class="btn btn-primary btn-sm mt-2" type="submit" name="update">Rediger</button>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            <c:if test="${not empty requestScope.error}">--%>
        <%--                <br/>--%>
        <%--                <p style="coler:red;font-size: large">${requestScope.error}</p>--%>
        <%--            </c:if>--%>
        <%--        </form>--%>

    </jsp:body>
</t:genericpage>
