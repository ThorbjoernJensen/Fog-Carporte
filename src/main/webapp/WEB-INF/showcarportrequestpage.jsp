<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
<%--         Demo Page for Employee Roles--%>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container-fluid pb-5 rounded" style="background: rgb(12, 32, 105)">

            <p class="text-center" style="color: aliceblue">Her er en liste over ikke godkendte forspørgelser</p>
            <%--gør den mobile friendly--%>
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-10 col-sm-12">
                    <div class="card" style="background: lightgrey">
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                <th>CarportId</th>
                                <th>Tag</th>
                                <th>Højde</th>
                                <th>Længde</th>
                                <th>Bredde</th>
                                <th>Skur</th>
                                <th>UserId</th>
                                <th>Status</th>
                                <th class="text-center">Forspørgelser</th>
                                </thead>
                                <c:forEach var="carports" items="${sessionScope.carportList}">
                                    <tr class="text-center">
                                        <td>${carports.carportId}</td>
                                        <td>${carports.roofId}</td>
                                        <td>${carports.height}</td>
                                        <td>${carports.length}</td>
                                        <td>${carports.width}</td>
                                        <td>${carports.shedId}</td>
                                        <td>${carports.userId}</td>
                                        <td>${carports.carportStatusId}</td>
                                        <td>
                                            <form action="${pageContext.request.contextPath}/fc/orderHandler"
                                                  method="post">
                                                <input class="btn btn-primary" type="submit" name="select"
                                                       value="Se forespørgelser">
                                                <input type="number" hidden id="carportId" name="carportId"
                                                       value="${carports.carportId}">
                                                <input type="number" hidden id="roofId" name="roofId"
                                                       value="${carports.roofId}">
                                                <input type="number" hidden id="height" name="height"
                                                       value="${carports.height}">
                                                <input type="number" hidden id="length" name="length"
                                                       value="${carports.length}">
                                                <input type="number" hidden id="width" name="width"
                                                       value="${carports.width}">
                                                <input type="number" hidden id="shedId" name="shedId"
                                                       value="${carports.shedId}">
                                                <input type="number" hidden id="userId" name="userId"
                                                       value="${carports.userId}">
                                                <input type="number" hidden id="carportStatusId" name="carportStatusId"
                                                       value="${carports.carportStatusId}">
                                                <input type="text" hidden id="token" name="token" value="10">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-1"></div>
            </div>
        </div>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
        </div>


    </jsp:body>
</t:genericpage>