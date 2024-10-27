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

        <title>Enomy Finances | Convert Currency</title>
    </head>
    <%@ include file="menu.jsp" %>
        <section class="home">
            <div class="flex-container row-1">
                <div class="text-text box box-add-expend">
                    <div class="convert-currency"><h2>Convert Currency</h2>
                        <p>Perform currency conversions with ease.</p>
                        
                        <!-- Currency conversion form -->
                        <form action="convert" method="post" id="currency-conversion-form">
                         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <label for="amount">Amount:</label>
                            <input type="number" id="amount" name="amount" min="300" max="5000" placeholder="Enter amount" required>
                            
                            <label for="from-currency">From Currency:</label>
                            <select class="select-s" id="from-currency" name="fromCurrency">
                                <option value="GBP">GBP</option>
                                <option value="USD">USD</option>
                                <option value="EUR">EUR</option>
                                <option value="BRL">BRL</option>
                                <option value="JPY">JPY</option>
                                <option value="TRY">TRY</option>
                            </select>
                            
                            <label for="to-currency">To Currency:</label>
                            <select class="select-s" id="to-currency" name="toCurrency">
                                <option value="GBP">GBP</option>
                                <option value="USD">USD</option>
                                <option value="EUR">EUR</option>
                                <option value="BRL">BRL</option>
                                <option value="JPY">JPY</option>
                                <option value="TRY">TRY</option>
                            </select>
						<!-- Result field -->
						<div id="conversion-result">
							<input type="text" id="result" name="result" readonly placeholder="Conversion Result" value="${result != null ? result : '0.0'}">
						</div>


						<button type="submit" id="convert-button">Convert</button>
                        </form>
                        
                        <p class="bottom"><strong>Transaction Fee:</strong> Please note that a transaction fee will be applied for each conversion.</p></div>
                </div>
                
            </div>
            
            <div class="table-wrap">
  <table class="table-responsive">
    <thead>
      <tr>
        <th>Initial currency amount</th>
        <th>Fee</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Up to 500</td>
        <td>3.5%</td>
      </tr>
      <tr>
        <td>Over 500</td>
        <td>2.7%</td>
      </tr>
      <tr>
        <td>Over 1500</td>
        <td>2.0%</td>
      </tr>
      <tr>
        <td>Over 2500</td>
        <td>1.5%</td>
      </tr>
    </tbody>
  </table>
</div>

            

            

              <%@ include file="footer.jsp" %>   
        </section>
        <script>
  // Function to format a number to two decimal places
  function formatToTwoDecimalPlaces(value) {
    // Ensure the value is a number
    var floatValue = parseFloat(value);
    // Check if it's a valid number
    if (!isNaN(floatValue)) {
      return floatValue.toFixed(2);
    } else {
      return '0.00'; // Or any default value you prefer
    }
  }

  // Format and display GBP balance
  var gbpBalanceElement = document.getElementById('GBP');
  gbpBalanceElement.innerText = '£' + formatToTwoDecimalPlaces(${balances['GBP']});

  // Format and display EUR balance
  var eurBalanceElement = document.getElementById('EUR');
  eurBalanceElement.innerText = '€' + formatToTwoDecimalPlaces(${balances['EUR']});

  // Format and display BRL balance
  var brlBalanceElement = document.getElementById('BRL');
  brlBalanceElement.innerText = 'R$' + formatToTwoDecimalPlaces(${balances['BRL']});

  // Format and display JPY balance
  var jpyBalanceElement = document.getElementById('JPY');
  jpyBalanceElement.innerText = '¥' + formatToTwoDecimalPlaces(${balances['JPY']});

  // Format and display TRY balance
  var tryBalanceElement = document.getElementById('TRY');
  tryBalanceElement.innerText = '₺' + formatToTwoDecimalPlaces(${balances['TRY']});

  // Format and display USD balance
  var usdBalanceElement = document.getElementById('USD');
  usdBalanceElement.innerText = '$' + formatToTwoDecimalPlaces(${balances['USD']});
</script>
	
	<script>
    	// Get the result value from the model attribute
    	var result = "${result}";

   	 	// Set the result value to the result input field
    	document.getElementById("result").value = result;
	</script>
	
    </body>
</html>