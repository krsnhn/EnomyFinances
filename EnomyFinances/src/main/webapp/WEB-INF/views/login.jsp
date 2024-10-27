<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Enomy Finance | Login</title>
<!-- External Stylesheets -->
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<!-- Google API Script -->
<script src="https://apis.google.com/js/platform.js?onload=startGoogleSignIn" async defer></script>
</head>
<body>
<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="row border rounded-5 p-3 bg-white shadow box-area">
        <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #695CFE;">
            <p class="text-white fs-5" style="font-family: 'Courier New', Courier, monospace; font-weight: 500;">Enomy-Finances</p>
            <div class="featured-image mb-3">
                <img src="images/1.png" class="img-fluid" style="width: 350px">
            </div>
            <small class="text-white text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Log in to explore personalized financial services.</small>
        </div>
        <div class="col-md-6 right-box" style="background-color: var(--background-white);">
            <div class="row align-items-center">
                <div class="header-text mb-4">
                    <h2>Welcome Back!</h2>
                    <p>We are happy to have you back.</p>
                </div>
                
              
                
                <!-- Login Form -->
                <c:url var="post_url" value="/login" />
				<form action="${post_url}" method="post">
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="input-group mb-3">
                        <input type="email" id="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address" name="username" required>
                    </div>
                    <div class="input-group mb-1">
                        <input type="password" id="password" class="form-control form-control-lg bg-light fs-6" placeholder="Password" name="password" required>
                    </div>
                    <div class="input-group mb-5 d-flex justify-content-between">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="formCheck">
                            <label for="formCheck" class="form-check-label text-secondary"><small>Remember Me</small></label>
                        </div>
                        <div class="forgot">
                            <small><a href="#">Forgot Password?</a></small>
                        </div>
                    </div>
                    <div class="input-group mb-3 submit">
                        <button type="submit" class="btn btn-lg btn-primary custom-btn w-100 fs-6">Login</button>
                    </div>
                </form>
                <!-- Google Sign-In Button -->
                <div class="input-group mb-3">
                    <button class="btn btn-lg btn-primary custom-btn w-100 fs-6" id="google-signin">
                        <img src="images/google.png" style="width:20px" class="me-2">
                        <small>Sign In with Google</small>
                    </button>
                </div>
                <!-- Sign Up Link -->
                <div class="row">
                    <small>Don't have an account? <a href="signup">Sign Up</a></small>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom Script -->
</body>
</html>
