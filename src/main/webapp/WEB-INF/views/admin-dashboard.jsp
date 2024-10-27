<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
</head>
<body>
<section class="home">
    <div class="box table-box">
                    <div class="transaction-list">
                    <p>Transaction History</p>
                    <div class="table-row default">
                        <div class="table-cell">
                            <p>First Name</p>
                        </div>
                        <div class="table-cell">
                            <p>Last Name</p>
                        </div>
                        <div class="table-cell">
                            <p>Email</p>
                        </div>
                        <div class="table-cell">
                            <p>Fee</p>
                        </div>
                    </div>
                    <!-- Loop through all the user -->
                   <c:forEach items="${users}" var="user">
                    <div class="table-row">
                        <div class="table-cell">
                            <p>${user.firstName}</p>
                        </div>
                        <div class="table-cell">
                            <p>${user.lastName}</p>
                        </div>
                        <div class="table-cell">
                            <p>${user.email}</p>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                </div>
        </section>
</body>


</html>


