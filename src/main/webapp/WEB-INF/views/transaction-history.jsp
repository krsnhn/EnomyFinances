<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enomy Finances | Transaction History</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<section class="home">

    <div class="box table-box">
                    <div class="transaction-list">
                    <p>Transaction History</p>
                    <div class="table-row default">
                        <div class="table-cell">
                            <p>From Currency</p>
                        </div>
                        <div class="table-cell">
                            <p>To Currency</p>
                        </div>
                        <div class="table-cell">
                            <p>Amount Converted</p>
                        </div>
                        <div class="table-cell">
                            <p>Fee</p>
                        </div>
                    </div>
                    <!-- Loop through recent purchases -->
                   <c:forEach items="${transactions}" var="transaction">
                    <div class="table-row">
                        <div class="table-cell">
                            <p>${transaction.fromCurrency}</p>
                        </div>
                        <div class="table-cell">
                            <p>${transaction.toCurrency}</p>
                        </div>
                        <div class="table-cell">
                            <p>${transaction.amount}</p>
                        </div>
                        <div class="table-cell">
                            <p>${transaction.fee}</p>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                </div>
                <%@ include file="footer.jsp" %>
        </section>
</body>


</html>
