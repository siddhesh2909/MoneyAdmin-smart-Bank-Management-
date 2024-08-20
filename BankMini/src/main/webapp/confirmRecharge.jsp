<%@page import="bank.model.Register"%>
<%@page import="bank.model.Recharge"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Recharge Details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
body {
	height: 100vh;
	width: 100%;
	background: linear-gradient(to bottom, #175d69 23%, #330c43 95%);
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	color: #fff;
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
	display: flex;
	align-items: center;
	justify-content: center;
}

.container {
	background-color: rgba(255, 255, 255, 0.1);
	border: 2px solid white;
	border-radius: 15px;
	box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
	padding: 20px;
	max-width: 600px;
	margin: auto;
}

h1 {
	color: #4CAF50;
	text-align: center;
}

table {
	width: 100%;
	margin-top: 20px;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ddd;
	background-color: transparent !important;
}

th, td {
	padding: 10px;
	text-align: left;
	color: #fff !important;
}

th {
	background-color: #175d69;
}

tr:nth-child(even) {
	background-color: rgba(255, 255, 255, 0.1);
}

.btn-primary {
	background-color: #175d69;
	border-color: #175d69;
	font-size: 18px;
	padding: 10px 20px;
	margin-top: 20px;
	width: 100%;
}
</style>
</head>

<body>
	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="Index.html"><img
					src="demo-logo.png" alt="LOGO"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fa-solid fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link"
							href="LoginDashboard.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
						<li class="nav-item"><a class="nav-link" href="#">About
								Us</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
						<li class="nav-item"><a class="nav-link"
							href="LoginView.html">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</section>
	<section class="main">
		<div class="container">
			<h1>Recharge Details</h1>
			<form action="FinalRecharge">
				<%
				Recharge r = (Recharge) session.getAttribute("recharge");
				Register rg = (Register) session.getAttribute("login");
				if (r != null) {
				%>
				<table class="table">
					<%
					if ("mobile(prepaid)".equals(r.getRecharge_type())) {
					%>
					<tr>
						<th>Mobile Number</th>
						<td><%=r.getMobNo()%></td>
					</tr>
					<%
					} else if ("dth".equals(r.getRecharge_type())) {
					%>
					<tr>
						<th>Customer ID</th>
						<td><%=r.getCust_id()%></td>
					</tr>
					<%
					} else if ("mobile(postpaid)".equals(r.getRecharge_type())) {
					%>
					<tr>
						<th>Mobile Number</th>
						<td><%=r.getMobNo()%></td>
					</tr>
					<%
					} else if ("electricity".equals(r.getRecharge_type())) {
					%>
					<tr>
						<th>Customer ID</th>
						<td><%=r.getCust_id()%></td>
					</tr>
					<%
					}
					%>
					<tr>
						<th>Recharge Type</th>
						<td><%=r.getRecharge_type()%></td>
					</tr>
					<tr>
						<th>Provider</th>
						<td><%=r.getProvider()%></td>
					</tr>
					<tr>
						<th>Account Number</th>
						<td><%=rg.getAccNumber()%></td>
					</tr>
					<tr>
						<th>Price</th>
						<td><%=r.getPrice()%></td>
					</tr>
				</table>
				<%
				} else {
				%>
				<div>No recharge details found.</div>
				<%
				}
				%>
				<input type="submit" value="Confirm" class="btn btn-primary">
			</form>
		</div>
	</section>
</body>

</html>