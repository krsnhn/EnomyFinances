<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Enomy Finances | Sign-Up</title>
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css">
<link rel="stylesheet" href="css/style.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<style>
	.iti{
		z-index: 9999 !important;
	}
	
	.container .logo {
  background: url('images/EFLogo.png') no-repeat center center;
  background-size: contain;
  width: 200px; /* Adjust the width as needed */
  height: 100px; /* Adjust the height as needed */
  color: #5d5d5d;
  font-style: italic;
  font-size: 20px;
  display: inline-block; /* Added to make the image behave like an inline element */
  text-indent: -9999px; /* Hides the text content */
  padding-bottom: 10px; /* Adjust the bottom padding as needed */
}
	
</style>
<div class="container">
            <a href="index.jsp" alt="Enomy Finance" class="logo"></a>
            </div>
	<div class="container d-flex justify-content-center align-items-center min-vh-100">
		<div class="row border rounded-5 p-3 bg-white shadow box-area">
			<div
				class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box"
				style="background: #0077b6;">
				<p class="text-white fs-5" style="font-family: 'Courier New', Courier, monospace; font-weight: 500;">Enomy-Finances</p>
				<div class="featured-image mb-3">
					<img src="images/3.png" class="img-fluid" style="width: 350px">
				</div>
				<small class="text-white text-wrap text-center"
       style="width: 17rem; font-family: 'Courier New', Courier, monospace;">Join us today! Create an account to start your financial journey with us.</small>
				
			</div>
			<div class="col-md-6 right-box">
				<div class="row align-items-center">
					<div class="header-text mb-4">
						<h2>Create an Account</h2>
						<p>We're excited to have you join Enomy-Finances!</p>
					</div>
					<div class="col-md-12 mt-2">
						<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
						<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
						<div class="alert alert-danger">
							<%= errorMessage %>
						</div>
						<% } %>
						<div id="password-error-message" class="alert alert-danger"
							style="display: none;"></div>
					</div>
					<form action="EnomyFinances/signupprocess" method="post">
    					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="input-group mb-3">
							<input type="text" id="first_name" name="first_name" required autocomplete="given-name" class="form-control form-control-lg bg-light fs-6" placeholder="First Name">

						</div>
						<div class="input-group mb-3">
							<input type="text" id="last_name" name="last_name" required autocomplete="family-name" class="form-control form-control-lg bg-light fs-6" placeholder="Last Name">
						</div>
						<div class="input-group mb-3">
							<input type="email" id="email" name="email" required autocomplete="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address">
						</div>
						<div class="input-group mb-3">
							<input type="password" id="password" name="password" required
								class="form-control form-control-lg bg-light fs-6" 
								placeholder="Password">
						</div>
						<div class="input-group mb-3">
							<input type="password" id="confirm_password"
								name="confirm_password" required
								class="form-control form-control-lg bg-light fs-6"
								placeholder="Confirm Password">
						</div>

			
						<div class="form-check mb-3">
							<input type="checkbox" id="terms_checkbox" name="terms_checkbox"
								class="form-check-input" required> <label for="email" class="form-check-label text-secondary"><small>I agree to the <a href="#" class="link">terms and conditions</a>.</small></label>
						</div>
						<div class="input-group mb-3">
							<button type="submit" class="btn btn-lg btn-primary custom-btn w-100 fs-6">Sign Up</button>
						</div>
					</form>
					<div class="row">
						<small>Already have an account? <a class="link" href="login">Log
								In</a></small>
					</div>
					

				</div>
			</div>
		</div>
	</div>

<script src="js/script.js"></script>
<script src="js/validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
