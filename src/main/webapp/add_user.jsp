<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align=center>
<h1>Add New User</h1>
<br>
<br>
<br>

<form action=LoginServlet method=post>
<table>
<tr><td>Enter Name:</td><td><input type=text name=txtName></td></tr>
<tr><td>Enter Password:</td><td><input type=password name=txtPwd></td></tr>
<tr><td><input type=submit value=Login></td><td><input type=reset></td></tr>
</table>
</form>


<a href="main_page.jsp">Back</a>
</div>

</body>
</html>