<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Lager
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Her kan du se en LagerBeholdningen

        <form action="${pageContext.request.contextPath}/fc/showmaterials" method="post">
            <table class="table">
                <thead>
                <th>materialId</th>
                <th>materialDescription</th>
                <th>materialByLenght</th>
                <th>quantity</th>
                <th>unitId</th>
                <th>pricePrMtr</th>
                <th>placementDescription</th>
                <th></th>
                <th></th>
                </thead>
                    <c:forEach var="MaterialItem" items="${applicationScope.MaterialList}">
                <tr>
                    <td>${MaterialItem.materialId}</td>
                    <td>${MaterialItem.materialDescription}</td>
                    <td>${MaterialItem.materialByLenght}</td>
                    <td>${MaterialItem.quantity}</td>
                    <td>${MaterialItem.unitId}</td>
                    <td>${MaterialItem.pricePrMtr}</td>
                    <td>${MaterialItem.placementDescription}</td>
                    <td>

                </c:forEach>


        </form>





    </jsp:body>
</t:genericpage>