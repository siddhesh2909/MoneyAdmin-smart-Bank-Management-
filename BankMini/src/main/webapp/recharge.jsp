<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recharge</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <style>
        body {
            height: 100vh;
            width: 100%;
            background: linear-gradient(to bottom, #175d69 23%, #330c43 95%);
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }

        #nav-bar {
            position: sticky;
            top: 0;
            z-index: 10;
        }

        .navbar {
            background: linear-gradient(to bottom, #175d69 23%, #175d69 95%);
            padding: 10px !important;
        }

        .navbar-brand img {
            height: 40px;
            padding-left: 20px;
        }

        .navbar-nav li {
            padding: 0 10px;
        }

        .navbar-nav li a {
            color: #fff;
            font-weight: 600;
            float: right;
            font-size: 20px;
            text-align: left !important;
        }

        .main {
            margin-top: 100px;
            color: #fff;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .error {
            height: 15px;
            color: red;
            font-size: 12px;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.1);
            border: 2px solid white;
            color: #fff;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
        }

        .card-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .card p {
            font-size: 16px;
            margin: 10px 0;
        }

        .card input[type="text"]::placeholder,
        .card select::placeholder {
            color: rgba(255, 255, 255, 0.6);
        }

        .card input[type="text"],
        .card select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #fff;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.2);
            color: #fff;
        }

        .card input[type="radio"] {
            margin-right: 10px;
        }

        .card label {
            font-size: 16px;
        }

        .btn-primary {
            background-color: #175d69;
            border-color: #175d69;
            font-size: 18px;
            padding: 10px 20px;
            margin-top: 20px;
            width: 100%;
        }

        .recharge {
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>

<body>
    <section id="nav-bar">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="Index.html"><img src="demo-logo.png" alt="LOGO"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa-solid fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="LoginDashboard.jsp">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">AboutUs</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                        <li class="nav-item"><a class="nav-link" href="LoginView.html">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </section>
    <section class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12 recharge">
                    <div class="card" style="width: 25rem;">
                        <div class="card-body">
                            <form id="rechargeForm" action="RechargeController">
                                <h5 class="card-title text-center">Mobile Recharge</h5>
                                <p>Mobile Number:</p>
                                <input type="text" id="mobileNumber" placeholder="Enter Mobile Number" name="mobNo"
                                    required>
                                <div class="error" id="mobileError"></div>
                                <p>Service Provider:</p>
                                <select name="provider">
                                    <option value="Vodafone">Vodafone</option>
                                    <option value="Airtel">Airtel</option>
                                    <option value="Jio">Jio</option>
                                    <option value="BSNL">BSNL</option>
                                </select>
                                <p>Type:</p>
                                <input type="radio" id="prepaid" name="type" value="mobile(prepaid)" checked>
                                <label for="prepaid">Prepaid</label><br>
                                <input type="radio" id="postpaid" name="type" value="mobile(postpaid)">
                                <label for="postpaid">Postpaid</label><br>
                                <p>Amount :</p>
                                <input type="text" id="amount" placeholder="Enter Amount" name="price" required>
                                <div class="error" id="amountError"></div>
                                <button type="button" class="btn btn-primary" onclick="validateForm()">Recharge</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
        function validateForm() {
            var mobileNumber = document.getElementById("mobileNumber").value;
            var amount = document.getElementById("amount").value;
            var mobileError = document.getElementById("mobileError");
            var amountError = document.getElementById("amountError");

            mobileError.textContent = "";
            amountError.textContent = "";

            var isValid = true;

            if (!/^\d{10}$/.test(mobileNumber)) {
                mobileError.textContent = "Please enter a valid 10-digit mobile number.";
                isValid = false;
            }

            if (isNaN(amount) || amount <= 18) {
                amountError.textContent = "Please enter an amount greater than 18.";
                isValid = false;
            }

            if (isValid) {
                document.getElementById("rechargeForm").submit();
            }
        }
    </script>
</body>

</html>
