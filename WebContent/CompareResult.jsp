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
	
	<div class="container">
		<h2>
			Loan Type : <span>${loantype}</span>
		</h2>

		<table class="table table-borderless">
			<thead>
				<tr>

					<th>Bank Name</th>
					<th>Loan Amount</th>
					<th>InterestRate</th>
					<th>Monthly Payment</th>
					<th>Total Interest</th>
					<th>Total Principal</th>
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
				<tr>
					<td>${citibankname}</td>
					<td>${loanamt}</td>
					<td>${citiinterestrate}</td>
					<td>${citibankpayment}</td>
					<td>${citibankinterest}</td>
					<td>${citibankprinciple}</td>
				</tr>
				<tr>
					<td>${sbibank}</td>
					<td>${loanamt}</td>
					<td>${sbiinterest}</td>
					<td>${sbibankpayment}</td>
					<td>${sbibankinterest}</td>
					<td>${sbibankprinciple}</td>
				</tr>

				<!-- <tr>
      <th>Best Bank: ${bankname }</th>
      </tr>-->
			</tbody>
		</table>
		<form method="POST" action="bestBank">
			<input type="hidden" name="userName" value="${uname}"> <select
				name="bestbank" id="bestbank" onchange="bestbank()" required="required">
				<option selected value="">Choose Option</option>
				<option value="Credibility">Credibility</option>
				<option value="Interest">Interest</option>
				<!-- <option value ="HomeLoan">Home Loan</option>-->
			</select>
			<button type="submit" class="registerbtn">Find best bank</button>
		</form>

	</div>

</body>
</html>
