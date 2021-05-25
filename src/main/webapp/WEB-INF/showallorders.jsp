<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Alle ordre</title>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container-fluid pb-5 p-lg-3" style="background: rgb(12, 32, 105)">
           <h3> <p class="text-center" style="color: aliceblue">Her er en liste over alle ordre</p></h3>
            <form action="${pageContext.request.contextPath}/fc/showsingleorder" method="post">

                <div class="card" style="background: lightgrey">
                    <div class="card-body">
                        <table class="table">
                            <thead class="text-center">
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
                            <tr class="text-center">
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
        </div>
        </div>
        </div>


    </jsp:body>
</t:genericpage>

