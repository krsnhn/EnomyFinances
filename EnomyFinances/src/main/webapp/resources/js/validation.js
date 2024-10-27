document.addEventListener("DOMContentLoaded", function() {
    const signUpForm = document.querySelector("form[action='signup']");
    const btn = document.querySelector("[type=submit]");

    const inputFields = {
        "first_name": validateField,
        "last_name": validateField,
        "email": validateField,
        "password": validatePassword,
        "confirm_password": validatePasswordConfirmation
    };

    Object.entries(inputFields).forEach(([fieldName, validateFunc]) => {
        validateFunc(fieldName);
    });

    signUpForm.addEventListener("submit", function(event) {
        event.preventDefault();
        validateForm().then(valid => {
            if (valid) {
                this.submit();
            }
        });
    });

    function validateField(fieldName) {
        const field = document.querySelector(`#${fieldName}`);
        field.addEventListener("focusout", function() {
            if (field.value.trim() === "") {
                showInvalid(field);
            } else {
                showValid(field);
            }
        });
    }

    function validatePassword(fieldName) {
        const passwordField = document.querySelector("#password");
        const confirmPasswordField = document.querySelector("#confirm_password");
        
        confirmPasswordField.addEventListener("keyup", function() {
            if (passwordField.value === confirmPasswordField.value) {
                showValid(passwordField);
                showValid(confirmPasswordField);
            } else {
                showInvalid(passwordField);
                showInvalid(confirmPasswordField);
            }
        });
    }

    function validatePasswordConfirmation(fieldName) {
        const confirmPasswordField = document.querySelector("#confirm_password");
        confirmPasswordField.addEventListener("focusout", function() {
            const passwordField = document.querySelector("#password");
            if (passwordField.value === "") {
                showInvalid(passwordField);
                showInvalid(confirmPasswordField);
            } else {
                validatePassword();
            }
        });
    }

    function checkEmailExists(email) {
        fetch('/EnomyFinances/check-email', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email: email }),
        })
        .then(response => response.json())
        .then(data => {
            const emailField = document.querySelector("#email");
            if (data.exists) {
                showInvalid(emailField);
            } else {
                showValid(emailField);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function validateForm() {
        return new Promise((resolve, reject) => {
            const emailField = document.querySelector("#email");
            const email = emailField.value.trim();
            if (email !== "") {
                checkEmailExists(email);
                resolve(true);
            } else {
                resolve(true);
            }
        });
    }

    function showValid(field) {
        field.classList.remove("is-invalid");
        field.classList.add("is-valid");
        btn.classList.remove("disabled");
    }

    function showInvalid(field) {
        field.classList.remove("is-valid");
        field.classList.add("is-invalid");
        btn.classList.add("disabled");
    }
});
