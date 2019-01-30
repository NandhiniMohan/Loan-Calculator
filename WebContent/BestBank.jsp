<!DOCTYPE html>
<html lang="en">
<head>
<title>Loan Calculation</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<script>
function goBack() {
	  window.history.back();
	}
</script>
<button onclick="goBack()">Go Back</button>
<form method="post" action="logout.jsp">
		<div class="dropdown" style="float: right;">
			<input type="submit" value="Logout" name="logout">
		</div>
	</form>
	<hr/>
	<div class="container">
		<div class="jumbotron">
			<h1>${bestBank}</h1>
			
			<p>
				When compared with the other banks, <span>${bestBank}</span>
				provides you the lowest interest rate/highest credibility (<span>${lowestInterestRate}</span>).
				So it will be best for your future plans.
			</p>
		</div>
	</div>

</body>
</html>
