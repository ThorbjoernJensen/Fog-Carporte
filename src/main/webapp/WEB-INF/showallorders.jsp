<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



    <t:genericpage>
    <jsp:attribute name="header">
         Her er en liste af alle ordre
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


            <c:forEach var="orderItem" items="${applicationScope.orderList}">
                <tr>
                    <td>${orderItem.orderId}</td>
                    <td>${orderItem.carportId}</td>
                    <td>${orderItem.price}</td>
                    <td>${orderItem.userId}</td>
                    <td>${orderItem.materialList}</td>
                    <td>${orderItem.orderDate}</td>
                    <td>${orderItem.orderStatusId}</td>
                    <td>
                        <button class="btn btn-primary " type="submit" name="singleOrder"
                                value="${orderItem.orderId}">se ordre
                        </button>
                    </td>

                </form>
            </c:forEach>


        </jsp:body>
    </t:genericpage>

