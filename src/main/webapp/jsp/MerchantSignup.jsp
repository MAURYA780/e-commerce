<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="x" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Merchant Singup Here</h1>
<h1 style="color: red">${neg}</h1>
<h1 style="color: red">${pos}</h1>
<x:form action="/merchant/signup" method="post" modelAttribute="merchantDto">
<fieldset>
<legend>Signup Here</legend>
<table>
<tr>
<th>Name:</th>
<th><x:input path="name" required="required"/></tr>
<th><span style="color: red"><x:errors path="name"/></span></th>
</tr>
<tr>
<th>Mobile:</th>
<th><x:input type="tel" path="mobile" pattern="[0-9]{10}" required="required"/></th>
<th><span style="color: red"><x:errors path="mobile"/></span></th>
</tr>
<tr>
<th>Email:</th>
<th><x:input type="email" path="email" required="required"/></th>
<th><span style="color: red"><x:errors path="email"/></span></th>
</tr>
<tr>
<th>Password:</th>
<th><x:input path="password" required="required"/></th>
<th><span style="color: red"><x:errors path="password"/></span></th>
</tr>

<tr>
<th>Date Of Birth:</th>
<th><x:input type="date" path="dob" required="required"/></th>
<th><span style="color: red"><x:errors path="dob"/></span></th>
</tr>
<tr>
<th>Gender:</th>
<th><x:radiobutton path="gender" value="male" required="required"/>Male</th>
<th><x:radiobutton path="gender" value="female" required="required"/>Female</th>
<th><x:radiobutton path="gender" value="other" required="required"/>Other</th>
<th><span style="color: red"><x:errors path="gender"/></span></th>
</tr>
<tr>
<th><button type="submit">Signup</button>
<th><button type="reset">Cancel</button>
</tr>
</table>
</fieldset>
</x:form>
<br>
<a href="/merchant"><button>Back</button></a>

</body>
</html>