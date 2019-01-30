<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Calculation</title>
<link href="Style.css" rel="stylesheet" type="text/css">
</head>

<body>
<button onclick="goBack()">Go Back</button>

<script type="text/javascript">
function bankname(){
var bankname = document.getElementById('bankname').value;
var selectedValue = bankname.options[bankname.selectedIndex].value;
	
}


function loantype(){
	var loantype = document.getElementById('loantype');
	var selectedValue = loantype.options[loantype.selectedIndex].value;

	}
function goBack() {
	  window.history.back();
	}
</script>



<form name = "home" method="post" action="DBConnector">
	<h1>Loan Calculation</h1>
			
			<input type="hidden" name="userName" value="${uname}"> 

			<select name="bankname" id="bankname" onchange="bankname()" required="required">
			<option selected value=""> Choose Bank Name </option>
			<option value ="IndianBank">Indian Bank</option>
			<option value ="CitiBank">Citi Bank</option>
			<option value ="SBI">SBI</option>
			</select>
			<select name = "loantype" id="loantype" onchange="loantype()" required = "required">
			<option selected value="">Choose Loan Type </option>
			<option value ="PersonalLoan">Personal Loan</option>
			<option value ="CarLoan">Car Loan</option>
			<!-- <option value ="HomeLoan">Home Loan</option>-->
			</select><br/><br/>
			
			<input type="text" placeholder="Enter Loan Amount" name="lamt" required><br /><br/>
			<input type="text" placeholder="Enter Loan Period" name="lperiod" required><br /><br/>
			
			<button type="submit" class="registerbtn">Check</button>
				
	</form>

</body>
</html>