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
	<script type="text/javascript">
function bestbank(){
var bestbank = document.getElementById("bestbank");
var selectedValue = bestbank.options[bestbank.selectedIndex].value;
}

function goBack() {
	  window.history.back();
	}
</script>
<button onclick="goBack()">Go Back</button>
	<div class="container">
		<h2>
			Loan Type : <span>${loantype}</span>
		</h2>

		<table class="table table-borderless">
			<thead>
				<tr>

					<th>BankName</th>
					<th>LoanAmount</th>
					<th>InterestRate</th>
					<th>MonthlyPayment</th>
					<th>TotalInterest</th>
					<th>TotalPrincipal</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${bankname}</td>
					<td>${loanamt}</td>
					<td>${interestrate}</td>
					<td>${payment}</td>
					<td>${interest}</td>
					<td>${principle}</td>
				</tr>

			</tbody>
		</table>
		<form method="POST" action="Compare">
			<input type="hidden" name="userName" value="${uname}">
			<!-- <input type="hidden" name="interest" value="${interest}">-->
			<button type="submit" name="check">Compare with other banks</button>
		</form> 
		<hr />



	</div>

</body>
</html>
