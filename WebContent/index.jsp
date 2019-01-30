<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Calculation</title>
<link href="Style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="Login">

		<div class="container">
			<h1>LOGIN</h1>
			<input type="text" placeholder="Your UserName" name="uname" required><br />
			<input type="password" placeholder="Your Password" name="pass" required><br />
			<button type="submit" class="registerbtn">Login</button>
			<button type="submit" class="registerbtn">Reset</button>
		</div>
		<p>
			Are you a new user? <a href="register.jsp">Register Here</a>.
		</p>
	</form>
					
</body>
</html>