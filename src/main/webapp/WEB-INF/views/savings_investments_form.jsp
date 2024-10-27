<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style2.css">
    <title>Enomy Finances | Savings and Investments</title>
</head>

<body>
    <%@ include file="menu.jsp" %>
    <section class="home">
    <section class="purpose">
    <div class="row">
<div class="purpose-col">
    <h3>Basic Savings Plan</h3>
    <p>
        <strong>Maximum investment per year:</strong> £20,000<br>
        <strong>Minimum monthly investment:</strong> £50<br>
        <strong>Minimum initial investment lump sum:</strong> N/A<br>
        <strong>Predicted returns per year:</strong> 1.2% to 2.4%<br>
        <strong>Estimated tax:</strong> 0%<br>
        <strong>RBSX group fees per month:</strong> 0.25%
    </p>
</div>

<div class="purpose-col">
    <h3>Savings Plan Plus</h3>
    <p>
        <strong>Maximum investment per year:</strong> £30,000<br>
        <strong>Minimum monthly investment:</strong> £50<br>
        <strong>Minimum initial investment lump sum:</strong> £300<br>
        <strong>Predicted returns per year:</strong> 3% to 5.5%<br>
        <strong>Estimated tax:</strong> 10% on profits above £12,000<br>
        <strong>RBSX group fees per month:</strong> 0.3%
    </p>
</div>

<div class="purpose-col">
    <h3> Managed Stock Investments</h3>
    <p>
        <strong>Maximum investment per year:</strong> Unlimited<br>
        <strong>Minimum monthly investment:</strong> £150<br>
        <strong>Minimum initial investment lump sum:</strong> £1000<br>
        <strong>Predicted returns per year:</strong> 4% to 23%<br>
        <strong>Estimated tax:</strong> 10% on profits above £12,000, 20% on profits above £40,000<br>
        <strong>RBSX group fees per month:</strong> 1.3%
    </p>
</div>

    </section>
            <div class="flex-container row-1">
                <div class="text-text box box-add-expend">
  			  <div class="convert-currency"><h2>Savings and Investments</h2>
   	 	<form action="${pageContext.request.contextPath}/savings-investments" method="post">
   	 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="initialLumpSum">Initial Lump Sum (GBP):</label>
        <input type="number" id="initialLumpSum" name="initialLumpSum" required>

        <label for="monthlyAmount">Monthly Amount (GBP):</label>
        <input type="number" id="monthlyAmount" name="monthlyAmount" required>

        <label for="investmentType">Investment Type:</label>
        <select class="select-s" id="investmentType" name="investmentType">
            <option value="Basic Savings Plan">Basic Savings Plan</option>
            <option value="Savings Plan Plus">Savings Plan Plus</option>
            <option value="Managed Stock Investments">Managed Stock Investments</option>
        </select>

        <button type="submit">Get Quote</button>
    </form>
    
    </div>
    </div>
    </div>
  			 <div class="flex-container row-1">
        <div class="text-text box box-add-expend">
            <div class="convert-currency">
                <h2>Savings and Investment Results</h2>
                <label>Initial Lump Sum: ${calculatedInvestments.initialLumpSum}</label>
                <label>Monthly Amount: ${calculatedInvestments.monthlyAmount}</label>
                <label>Investment Type: ${calculatedInvestments.investmentType}</label>

                <!-- Results for 1 year -->
                <label><strong>For 1 year</strong></label>
                <label>Min Returns: ${calculatedInvestments.minReturns1Year}</label>
                <label>Max Returns: ${calculatedInvestments.maxReturns1Year}</label>

                <!-- Results for 5 years -->
                <label><strong>For 5 years</strong></label>
                <label>Min Returns: ${calculatedInvestments.minReturns5Years}</label>
                <label>Max Returns: ${calculatedInvestments.maxReturns5Years}</label>

                <!-- Results for 10 years -->
                <label><strong>For 10 years</strong></label>
                <label>Min Returns: ${calculatedInvestments.minReturns10Years}</label>
                <label>Max Returns: ${calculatedInvestments.maxReturns10Years}</label>
            </div>
        </div>
    </div>

 <%@ include file="footer.jsp" %>
    </section>
</body>
</html>
