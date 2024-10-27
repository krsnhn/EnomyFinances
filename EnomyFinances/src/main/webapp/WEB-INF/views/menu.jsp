<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
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
    <body>
        <nav class="sidebar close">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="images/EFLogo.png" alt="EFlogo.png" >
                    </span>

                    <div class="text header-text">
                        <span class="name">Enomy</span>
                        <span class="profession">Finance</span>
                    </div>
                </div>
                <i class="bx bx-chevron-right toggle"></i>
            </header>

            <div class="menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="dashboard">
                                <i class="bx bx-home-alt icon"></i>
                                <span class="text nav-text">Dashboard</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="investment">
                                <i class='bx bx-candles icon' ></i>
                                <span class="text nav-text">Investment</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-wallet icon'></i>
                                <span class="text nav-text">Update Balance</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="convert-currency">
                                <span class="material-symbols-outlined icon">
                                    currency_exchange
                                </span>
                                <span class="text nav-text">Convert Currency</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-envelope icon' ></i>
                                <span class="text nav-text">Contact Us</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-cog icon' ></i>
                                <span class="text nav-text">Settings</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="bottom-content">
                    <li class="bot1">
                        <a href="/EnomyFinances/">
                            <i class="bx bx-log-out icon"></i>
                            <span class="text nav-text">Logout</span>                              			
                        </a>
                    </li>

                    <li class="mode">
                        <div class="moon-sun">
                            <i class="bx bx-moon icon"></i>
                            <i class="bx bx-sun icon"></i>
                        </div>
                        
                        <span class="mode-text text">Dark Mode</span>
                        <div class="toggle-switch">
                            <span class="switch"></span>
                        </div>
                        
                    </li>
                </div>
            </div>
        </nav>
	<script src="js/script2.js"></script>
</body>
</html>