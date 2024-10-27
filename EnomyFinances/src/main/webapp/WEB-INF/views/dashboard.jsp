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
		<%@ include file="menu.jsp" %>
        <section class="home">
            <div class="text"><p>Welcome, ${firstName} ${lastName}!</p></div>
            <div class="flex-container row-1">
			<div class="text box box-balance">
				<div class="balance">
					<div class="balance-icon bx bx-wallet"></div>
					<div class="balance-amount" id="availableBalance">$${balance}</div>
					<div class="balance-description">Total Balance USD</div>
				</div>
			</div>
			<div class="text box box-expenses">
				<div class="balance">
					<div class="balance-icon bx bx-fork"></div>
					<div class="balance-amount" id="foodsDrinksExpense">$${foodsDrinksExpense}</div>
					<div class="balance-description">Foods & Drinks</div>
				</div>
			</div>
			<div class="text box box-expenses">
				<div class="balance">
					<div class="balance-icon bx bxs-bank"></div>
					<div class="balance-amount" id="billsUtilitiesExpense">$${billsUtilitiesExpense}</div>
					<div class="balance-description">Bills & Utilities</div>
				</div>
			</div>
			<div class="text box box-expenses">
				<div class="balance">
					<div class="balance-icon bx bx-shopping-bag"></div>
					<div class="balance-amount" id="othersExpense">$${othersExpense}</div>
					<div class="balance-description">Others</div>
				</div>
			</div>
			<div class="text-text box box-add-expend">
                    <div class="text-text add-expenses-text">Add Expenses</div>
                    <form action="addExpense" method="post"> 
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <label for="purpose">Purpose:</label>
                        <input type="text" id="purpose" name="purpose" required>
                    
                        <label for="sum">Sum:</label>
                        <input type="number" id="sum" name="sum" min="0" required>
                    
                        <label for="date">Date:</label>
                        <input type="date" id="date" name="date" required>
                    
                        <label for="category">Category:</label>
                        <select id="category" name="category" required>
                            <option value="">Select a category</option>
                            <option value="Foods and Drinks">Foods and Drinks</option>
                            <option value="Bills and Utilities">Bills and Utilities</option>
                            <option value="Others">Others</option>
                        </select>
                        
                        <button type="submit">Submit</button>
                    </form>
                </div>

                <div class="box table-box">
                    <div class="transaction-list">
                    <p>Recent Transactions</p>
                    <div class="table-row default">
                        <div class="table-cell">
                            <p>Purpose</p>
                        </div>
                        <div class="table-cell">
                            <p>Category</p>
                        </div>
                        <div class="table-cell">
                            <p>Sum</p>
                        </div>
                        <div class="table-cell">
                            <p>Date</p>
                        </div>
                    </div>
                    <!-- Loop through recent purchases -->
                    <c:forEach items="${recentPurchases}" var="purchase">
                    <div class="table-row">
                        <div class="table-cell">
                            <p>${purchase.getPurpose()}</p>
                        </div>
                        <div class="table-cell">
                            <p>${purchase.getCategory().getName()}</p>
                        </div>
                        <div class="table-cell">
                            <p>${purchase.getSum()}</p>
                        </div>
                        <div class="table-cell">
                            <p>${purchase.getDate()}</p>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                </div>


			
                
                



        </section>
        <script>
  // Function to format a number to two decimal places
  function formatToTwoDecimalPlaces(value) {
    return parseFloat(value).toFixed(2);
  }

  // Format and display balance
  var balanceElement = document.getElementById('availableBalance');
  balanceElement.innerText = '$' + formatToTwoDecimalPlaces(${balance});

  // Format and display foods & drinks expense
  var foodsDrinksExpenseElement = document.getElementById('foodsDrinksExpense');
  foodsDrinksExpenseElement.innerText = '$' + formatToTwoDecimalPlaces(${foodsDrinksExpense});

  // Format and display bills & utilities expense
  var billsUtilitiesExpenseElement = document.getElementById('billsUtilitiesExpense');
  billsUtilitiesExpenseElement.innerText = '$' + formatToTwoDecimalPlaces(${billsUtilitiesExpense});

  // Format and display others expense
  var othersExpenseElement = document.getElementById('othersExpense');
  othersExpenseElement.innerText = '$' + formatToTwoDecimalPlaces(${othersExpense});
</script>
        
	<script src="js/script2.js"></script>
    </body>
</html>