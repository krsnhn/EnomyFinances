<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/style2.css">
        <link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />        

        <title>Dashboard</title>
    </head>
    <body>
        <%@ include file="menu.jsp" %>

        <section class="home">
            <div class="text"><p>Welcome, ${firstName} ${lastName}!</p></div>
			<div class="flex-container row-1">
                <div class="text-text savings-investment-box">
                    <div class="savings-investments">
                        <h2>Savings and Investments</h2>
                        <p>Get a personalized investment quote.</p>
                        
                        <!-- Savings and investments form -->
                        <form id="savings-investments-form">
                            <label for="initial-lump-sum">Initial Lump Sum (GBP):</label>
                            <input type="number" id="initial-lump-sum" name="initial-lump-sum" min="0" placeholder="Enter initial amount">
                            
                            <label for="monthly-amount">Monthly Amount (GBP):</label>
                            <input type="number" id="monthly-amount" name="monthly-amount" min="0" placeholder="Enter monthly amount">
                            
                            <label for="investment-type">Investment Type:</label>
                            <select class="select-s" id="investment-type" name="investment-type">
                                <option value="basic-savings-plan">Basic Savings Plan</option>
                                <option value="savings-plan-plus">Savings Plan Plus</option>
                                <option value="managed-stock-investments">Managed Stock Investments</option>
                            </select>
                            
                            <!-- Result fields -->
                            <div id="investment-quote">
                                <label for="max-returns">Max Returns (1 year):</label>
                                <input type="text" id="max-returns" name="max-returns" readonly>
                                
                                <label for="min-returns">Min Returns (1 year):</label>
                                <input type="text" id="min-returns" name="min-returns" readonly>
                                
                                <!-- Add fields for other time frames as needed -->
                            </div>
                            
                            <button type="submit">Get Quote</button>
                        </form>
                        
                        <p class="bottom"><strong>Transaction Fee:</strong> Please note that a transaction fee will be applied for each investment.</p>
                    </div>
            </div>

        </section>   
        <script src="script.js"></script>
    </body>
            
        
	<script src="js/script2.js"></script>
    </body>
</html>