<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enomy Finance</title>
</head>
<style>
<style>
/* Start Global Rules */
* {
  box-sizing: border-box;
}
body {
  font-family: 'Open Sans', sans-serif;
  margin: 0; /* Remove default body margin */
  padding: 0; /* Remove default body padding */
  background: url('images/background.jpg') no-repeat center center fixed;
  background-size: cover; /* Make the background cover the entire screen */
}
a {
  text-decoration: none;
}
ul {
  list-style: none;
  padding: 0;
  margin: 0;
}
.container {
  padding-left: 15px;
  padding-right: 15px;
  margin-left: auto;
  margin-right: auto;
}
/* Small */
@media (min-width: 768px) {
  .container {
    width: 750px;
  }
}
/* Medium */
@media (min-width: 992px) {
  .container {
    width: 970px;
  }
}
/* Large */
@media (min-width: 1200px) {
  .container {
    width: 1170px;
  }
}
/* End Global Rules */

/* Start Landing Page */
.landing-page header {
  min-height: 80px;
  display: flex;
}
@media (max-width: 767px) {
  .landing-page header {
    min-height: auto;
    display: initial;
  }
}
.landing-page header .container {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
@media (max-width: 767px) {
  .landing-page header .container {
    flex-direction: column;
    justify-content: center;
  }
}
.landing-page header .logo {
  color: #5d5d5d;
  font-style: italic;
  text-transform: uppercase;
  font-size: 20px;
}
@media (max-width: 767px) {
  .landing-page header .logo {
    margin-top: 20px;
    margin-bottom: 20px;
  }
}
.landing-page header .links {
  display: flex;
  align-items: center;
}
@media (max-width: 767px) {
  .landing-page header .links {
    text-align: center;
    gap: 10px;
  }
}
.landing-page header .links li {
  margin-left: 30px;
  color: #5d5d5d;
  cursor: pointer;
  transition: .3s;
}
@media (max-width: 767px) {
  .landing-page header .links li {
    margin-left: auto;
  }
}
.landing-page header .links li:last-child {
  border-radius: 20px;
  padding: 10px 20px;
  color: white; /* Change font color to white */
  background-color: #0077b6;
  cursor: pointer;
  transition: .3s;
}
.landing-page header .links li:last-child :hover {
  color: white; /* Change font color to white */
  background-color: #0077b6;
}
.landing-page header .links li:not(:last-child):hover {
  color: #0077b6;
}
.landing-page header .links li:last-child a {
  color: white;
}

.landing-page header .links li:last-child a:hover {
  color: black;
}
.landing-page .content .container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 140px;
  min-height: calc(100vh - 80px);
}
@media (max-width: 767px) {
  .landing-page .content .container {
    gap: 0;
    min-height: calc(100vh - 101px);
    justify-content: center;
    flex-direction: column-reverse;
  }
}
@media (max-width: 767px) {
  .landing-page .content .info {
    text-align: center;
    margin-bottom: 15px 
  }
}
.landing-page .content .info h1 {
  color: #5d5d5d;
  font-size: 44px;
}
.landing-page .content .info p {
  margin: 0;
  line-height: 1.6;
  font-size: 15px;
  color: #5d5d5d;
}
.landing-page .content .info button {
  border: 0;
  border-radius: 20px;
  padding: 12px 30px;
  margin-top: 30px;
  cursor: pointer;
  color: #FFF;
  background-color: #0077b6;
}
.landing-page .content .image img {
  max-width: 100%;
}

.landing-page header .links li a {
  color: #5d5d5d;
  text-decoration: none;
  cursor: pointer;
  transition: .3s;
}


/* End Landing Page */
.about-section {
  background-color: #f4f4f4;
  padding: 50px 0;
}

.about-section .container {
  text-align: center;
}

.about-section h2 {
  color: #333;
  font-size: 36px;
}

.about-section p {
  color: #666;
  font-size: 18px;
}

/* End About Section */

/* Start Contact Section */
.contact-section {
  background-color: #fff;
  padding: 50px 0;
}

.contact-section .container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.contact-section form {
  width: 60%;
}

.contact-section form input,
.contact-section form textarea {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.contact-section form button {
  padding: 12px 30px;
  border: 0;
  border-radius: 20px;
  cursor: pointer;
  color: #FFF;
  background-color: #0077b6;
}

.contact-section .info {
  width: 40%;
  text-align: center;
}

.contact-section .info h2 {
  color: #333;
  font-size: 36px;
}

.contact-section .info p {
  color: #666;
  font-size: 18px;
}

/* End Contact Section */
</style>


<body>
      <div class="landing-page">
        <header>
          <div class="container">
            <a href="images/EFLogo.png" alt="Enomy Finance" class="logo"></a>
            <ul class="links">
                    <li><a href="#">Home</a></li>
                    <li><a href="#about-section">About Us</a></li>
                    <li><a href="#contact-section">Contact Us</a></li>
                    <li><a href="signup">Get Started</a></li>
                </ul>
          </div>
        </header>
        <div class="content">
          <div class="container">
            <div class="info">
              <h1>Enomy Finance</h1>
              <p>Enomy Finance - Empowering Your Financial Freedom.</p>
              <button>Button name</button>
          </div>
        </div>
      </div>
      </div>
      <!-- End Landing Page -->
       <!-- About Section -->
    <div id="about-section" class="about-section">
        <div class="container">
            <h2>About Us</h2>
            <p>Enomy Finance is your trusted partner on the path to financial empowerment. Our mission is simple- to provide individuals and businesses with accessible and user-friendly financial solutions. We believe in the transformative power of financial literacy and strive to make managing your finances seamless. At Enomy, transparency, integrity, and empowerment are our core values. We offer a comprehensive range of tools, from investment planning to currency conversions, all designed to help you make informed decisions and achieve your financial goals. Join us at Enomy Finance, where your financial well-being is our priority, and let's embark on a journey towards lasting financial freedom together.</p>
        </div>
    </div>

    <!-- Contact Section -->
     <div id="contact-section" class="contact-section">
        <div class="container">
            <form>
                <h2>Contact Us</h2>
                <input type="text" placeholder="Your Name">
                <input type="email" placeholder="Your Email">
                <textarea placeholder="Your Message"></textarea>
                <button>Submit</button>
            </form>

            <div class="info">
                <h2>Contact Information</h2>
                <p>Email: info@enomyfinance.com</p>
                <p>Phone: +1 (123) 456-7890</p>
            </div>
        </div>
    </div>
</body>
</html>