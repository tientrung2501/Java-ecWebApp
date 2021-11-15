<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="products" scope="request" type="java.util.List<com.ute.ecwebapp.beans.Product>"/>

<t:main>
    <jsp:body>
        <div class="card">
            <h4 class="card-header d-flex justify-content-between">
                Categories
                <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Product/Add" role="button">
                    <i class="fa fa-plus" aria-hidden="true"></i>
                    Add Product #1
                </a>
            </h4>
            <c:choose>
                <c:when test="${products.size() == 0}">
                    <div class="card-body">
                        <div class="card-text">Không có dữ liệu.</div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Product</th>
                                <th>Description</th>
                                <th class="text-right">Price</th>
                                <th class="text-right">Quantity</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${products}" var="p">
                                <tr>
                                    <td>${p.proID}</td>
                                    <td>${p.proName}</td>
                                    <td>${p.tinyDes}</td>
                                    <td class="text-right"><fmt:formatNumber value="${p.price}" type ="number"/></td>
                                    <td class="text-right">${p.quantity}</td>
                                    <td class="text-right">
                                        <a class="btn btn-outline-primary btn-sm" href="${pageContext.request.contextPath}/Admin/Product/Edit?id=${p.proID}" role="button">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</t:main>