<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
</head>
<body>

<h1>This is Customer Page</h1>
<h1 style="color:green">${pos}</h1>
<h1 style="color:red">${neg}</h1>
	<form>
		<fieldset>
			<legend>Login Here,</legend>
			<table>
				<tr>
					<th>Email:</th>
					<th><input type="email" name="email" required="required"></th>
				</tr>
				<tr>
					<th>Password:</th>
					<th><input type="password" name="password" required="required"></th>
				</tr>
				<tr>
					<th><button>Login</button></th>
					<th><button type="reset">Cancel</button></th>
				</tr>
				<tr>
				<th	 colspan="2"><a href="/customer/signup">New? Click here to Create Account</a></th>
				</tr>
			</table>
		</fieldset>
	</form>
	<br>
	<a href="/Home"><button>Back</button></a>
	</body>
</html>