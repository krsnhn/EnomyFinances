const body = document.querySelector("body"),
      sidebar = body.querySelector(".sidebar"),
      toggle = body.querySelector(".toggle"),
      modeSwitch = body.querySelector(".toggle-switch"),
      modeText = body.querySelector(".mode-text");

// Function to set dark mode
function setDarkMode() {
    body.classList.add("dark");
    modeText.innerText = "Light Mode";
    localStorage.setItem("darkModeEnabled", "true");
}

// Function to set light mode
function setLightMode() {
    body.classList.remove("dark");
    modeText.innerText = "Dark Mode";
    localStorage.removeItem("darkModeEnabled");
}

// Check if dark mode was enabled previously
if (localStorage.getItem("darkModeEnabled")) {
    setDarkMode();
}

// Toggle sidebar
toggle.addEventListener("click", () =>{
    sidebar.classList.toggle("close");
});

// Toggle dark mode
modeSwitch.addEventListener("click", () =>{
    if (body.classList.contains("dark")) {
        setLightMode();
    } else {
        setDarkMode();
    }
});



//--------------------------------------------------------------------------------------


// JavaScript function to add a new purchase
function addPurchase(purchaseData) {
    // Send AJAX request to add the purchase
    $.ajax({
        url: "/addPurchase",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(purchaseData),
        success: function (data) {
            // Update the HTML content of the recent transactions table
            updateRecentTransactions(data);
        },
        error: function (xhr, status, error) {
            console.error("Error adding purchase:", error);
        }
    });
}

// JavaScript function to update the recent transactions table
function updateRecentTransactions(recentPurchases) {
    // Clear existing table rows
    $(".transaction-list .table-row").remove();
    
    // Add new table rows for each purchase
    recentPurchases.forEach(function (purchase) {
        var newRow = $("<div class='table-row'></div>");
        newRow.append("<div class='table-cell'><p>" + purchase.purpose + "</p></div>");
        newRow.append("<div class='table-cell'><p>" + purchase.category + "</p></div>");
        newRow.append("<div class='table-cell'><p>" + purchase.sum + "</p></div>");
        newRow.append("<div class='table-cell'><p>" + purchase.date + "</p></div>");
        $(".transaction-list").append(newRow);
    });
}

//-----------------------------------------------------------------------------------------------
// Function to calculate maximum returns
document.addEventListener("DOMContentLoaded", function () {
    // Event listener for the form submission
    document.getElementById("savings-investments-form").addEventListener("submit", function (event) {
        event.preventDefault();

        // Get user input from the form
        const initialLumpSum = parseFloat(document.getElementById("initial-lump-sum").value);
        const monthlyAmount = parseFloat(document.getElementById("monthly-amount").value);
        const investmentType = document.getElementById("investment-type").value;

        // Validate user input
        if (isNaN(initialLumpSum) || isNaN(monthlyAmount) || initialLumpSum < 0 || monthlyAmount < 0) {
            alert("Please enter valid numerical values for Initial Lump Sum and Monthly Amount.");
            return;
        }

        // Get the annual rate based on the investment type
        let annualRate;
        switch (investmentType) {
            case "basic-savings-plan":
                annualRate = 0.03; // Adjust the rate based on your needs
                break;
            case "savings-plan-plus":
                annualRate = 0.05;
                break;
            case "managed-stock-investments":
                annualRate = 0.08;
                break;
            default:
                annualRate = 0;
        }

        // Calculate max and min returns
        const maxReturns = calculateMaxReturns(initialLumpSum, monthlyAmount, annualRate);
        const minReturns = calculateMinReturns(initialLumpSum, monthlyAmount, annualRate);

        // Display the results or update the UI as needed
        document.getElementById("max-returns").value = maxReturns.toFixed(2);
        document.getElementById("min-returns").value = minReturns.toFixed(2);
    });

    // Function to calculate maximum returns
    function calculateMaxReturns(initialLumpSum, monthlyAmount, annualRate) {
        const years = 10;
        const totalInvestment = initialLumpSum + monthlyAmount * 12 * years;
        return totalInvestment * Math.pow(1 + annualRate, years);
    }

    // Function to calculate minimum returns
    function calculateMinReturns(initialLumpSum, monthlyAmount, annualRate) {
        const years = 1;
        const totalInvestment = initialLumpSum + monthlyAmount * 12 * years;
        return totalInvestment * Math.pow(1 + annualRate, years);
    }
});

    
