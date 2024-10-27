<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/style2.css">
<title>Enomy Finances | Contact Us</title>
</head>
<script type="text/javascript">

function showMessage() {
    var form = document.querySelector('form');
    var messageSent = document.getElementById('message-sent');

    // Hide the form
    form.style.display = 'none';

    // Show the "Message Sent" message
    messageSent.style.display = 'block';

    // Reset the form after 3 seconds
    setTimeout(function() {
        form.reset();
        form.style.display = 'block'; 
        messageSent.style.display = 'none'; 
    }, 2000); 
}
</script>
<body>
<%@ include file="menu.jsp" %>
<section class="home">
<section class="location">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d506610.0468353989!2d125.12140562655699!3d7.253245914523654!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x32f96d9f519e327f%3A0xb53a24589f79c573!2sDavao%20City%2C%20Davao%20del%20Sur!5e0!3m2!1sen!2sph!4v1698315521776!5m2!1sen!2sph" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</section>
    <div class="flex-container row-1">
                <div class="text-text box box-add-expend">
  			  <div class="convert-currency"><h2>Contact Information</h2>
                <div>
                    <i class="fa fa-home"></i>
                        <span>
                            <h5>123 ABC Street, DEF Building</h5>
                            <p>Davao City, Philippines</p>
                        </span>
                </div>
                <div>
                    <i class="fa fa-phone"></i>
                        <span>
                            <h5>+1 (123) 456-7890</h5>
                            <p>Monday to Sunday, 6AM to 9PM</p>
                        </span>
                </div>
                <div>
                    <i class="fa fa-envelope"></i>
                        <span>
                            <h5>info@enomyfinance.com</h5>
                            <p>Email us your query</p>
                        </span>
                </div>
                </div>
                </div>
               
             <div class="text-text box box-add-expend"> 
              <div class="convert-currency"><h2>Contact Us</h2>
                <!-- Inside your contact form -->
                <form onsubmit="return false;">
                <label >Full Name</label>
                <input type="text" name="name" placeholder="Enter your name" required>
                <label >Email Address</label>
                <input type="email" name="email" placeholder="Enter email address" required>
                <label >Message</label>
                <textarea rows="8" name="message" placeholder="Message" required></textarea>
                <button type="submit" onclick="showMessage()">Send Message
                <i class="fa fa-send"></i></button>
                 </form>
                 </div>
                <div id="message-sent" style="display: none;">
                    <p>Message Sent! Thank you for contacting us.</p>
                </div>          
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</section>


</body>
</html>