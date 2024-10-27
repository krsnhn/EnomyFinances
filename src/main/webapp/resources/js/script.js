// js/script.js

document.addEventListener("DOMContentLoaded", function() {
    // Timer countdown function
    function startTimer(duration, display) {
        let timer = duration;
        setInterval(function () {
            // Calculate minutes and seconds
            let minutes = parseInt(timer / 60, 10);
            let seconds = parseInt(timer % 60, 10);

            // Format minutes and seconds to display with leading zeros
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            // Update the countdown display
            display.textContent = "Redirecting in " + seconds + " seconds...";

            // Update the countdown value in the span element
            let timerElement = document.getElementById("timer");
            if (timerElement) {
                timerElement.textContent = seconds;
            }

            // Decrement the timer
            if (--timer < 0) {
                // Redirect to the login page after the timer expires
                window.location.href = "login";
            }
        }, 1000); // Update the countdown every 1 second (1000 milliseconds)
    }

    // Start the countdown timer with a duration of 5 seconds
    let timer = 5; // 5 seconds
    let display = document.querySelector("#countdown");
    startTimer(timer, display);
});


//------------------------------------------------------------------------------------------------------------------------------------------------------
