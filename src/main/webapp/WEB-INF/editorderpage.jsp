<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Edit order</title>
<t:genericpage>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container-fluid" style="background: rgb(12, 32, 105)">
            <h3 class="mb-3 text-center" style="color: aliceblue">Rediger prisen </h3>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">

                    <form action="${pageContext.request.contextPath}/fc/showsingleorder" method="post">
                        <input type="hidden" name="order_id" value="${requestScope.orderItem.orderId}"/>

                        <div class="input-group input-group-sm mb-3 text-center" style="color: aliceblue">
                            <div class="form-group">
                                <label class="form-check-label" for="price">Pris: </label>
                                <input id="price" class="form-control text-center" type="number" name="price"
                                       value="${requestScope.orderItem.price}"/>
                                <button class="btn btn-primary btn-sm mt-2" type="submit" name="editPrice">Rediger
                                </button>
                            </div>
                        </div>

                        <c:if test="${not empty requestScope.error}">
                            <br/>
                            <p style="coler:red;font-size: large">${requestScope.error}</p>
                        </c:if>

                    </form>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
