<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
</head>

<style>

    .fogblue {
        background: rgb(12, 32, 105)
    }

    .textfarve {
        color: aliceblue;
    }

</style>
<body>
<div class="container">
    <!--
        This header is inspired by this bootstrap
        example: https://getbootstrap.com/docs/5.0/examples/pricing/
    -->


    <header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 fogblue border-bottom shadow-sm">
        <div class="h5 my-0 me-md-auto fw-normal">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/Images/logo.png"
                                                          height="126" alt="Logo for Fog-carport"/></a>
                </div>
                <div style="color: aliceblue" class="col-sm-12 col-md-6 col-lg-9 pt-3">
                    <p>Velkommen til Fog-carport</p>
                    <c:if test="${sessionScope.user != null}">
                        user: ${sessionScope.user.email}
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                    <a STYLE="color: aliceblue " type="button" class="btn btn-sm  btn-outline-secondary"
                       href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                    </c:if>
                </div>
                <p style="font-size: small">
                    <jsp:invoke fragment="header"/>
                </p>
            </div>
        </div>
        <nav class="my-2 my-md-0 me-md-3">
            <c:if test="${sessionScope.user.role == 'employee' }">
                <div class="row">
                    <div class="col-2"></div>

                    <div class="col-sm-3">
                        <a class="p-2 textfarve" href="${pageContext.request.contextPath}/fc/employeepage">Home</a>
                    </div>
                    <div class="col-sm-3">
                        <a class="p-2 textfarve" href="${pageContext.request.contextPath}/fc/showOrders">Order</a>
                    </div>
                    <div class="col-sm-3">
                        <a class="p-2 textfarve"
                           href="${pageContext.request.contextPath}/fc/showcarportrequestpage">Forspørgelser</a>
                    </div>
                    <div class="col-1"></div>
            </div>



</c:if>
<%--        <a class="p-2 text-dark" href="#">Orders</a>--%>
<%--        <a class="p-2 text-dark" href="#">Profile</a>--%>
<%--        <a class="p-2 text-dark" href="#">About</a>--%>
</nav>

<div>


    <c:if test="${sessionScope.user != null}">
<%--        ${sessionScope.user.email}--%>
    </c:if>

    <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
    <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
    <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

    <c:if test="${isNotLoginPage && isNotRegisterPage}">
    <c:if test="${sessionScope.user != null }">
    </c:if>
    <c:if test="${sessionScope.user == null }">
        <a STYLE="color: aliceblue" type="button" class="btn btn-sm  btn-outline-secondary"
           href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
        <a STYLE="color: aliceblue " type="button" class="btn btn-sm  btn-outline-secondary"
           href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
    </c:if>
</div>
</c:if>
</header>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>
</div>
</div>
</body>
</html>