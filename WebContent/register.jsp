<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Calculation</title>
<link href="Style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="Registration">
		<div class="container">
			<h1>REGISTER</h1>

			<input type="text" placeholder="Your FirstName" name="fname"><br /> 
			<input type="text" placeholder="Your LastName" name="lname"><br/>
			<input type="text" placeholder="Your Email Id" name="email"><br/>
			<input type="text" placeholder="Your UserName" name="uname"><br/>				
			<input type="password" placeholder="Your Password" name="pass"><br /> 
						
			<input type="submit" class="registerbtn" value = "Register">
			<input type="reset" class="registerbtn" value = "Reset">
		</div>
<p> Already registered!! <a href="index.jsp">Login Here</a></p>
		
	</form>
	</body>
</html>