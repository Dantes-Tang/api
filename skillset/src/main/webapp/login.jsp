<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>DRMS</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
body{
	background-image:url("images/bg_login.png");
	background-repeat:none;
	background-size:100% 100%;
}
table {
	margin: auto;
	height: 0;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	text-align: center;
	width: 25%;
	background-color: #c1e1fc;
	border-radius:5px;
	min-width:300px;
}

table td {
	padding: 20px;
}

table input {
	width: 100%;
	font-size: 17px;
}

table .company-name {
    background-image: url("images/capgemini.png");
    width: 100%;
    height: 28px;
    display: inline-block;
    background-repeat: no-repeat;
    line-height: 28px;
    font-size: 25px;
    font-weight: bold;
    text-align: left;
    padding-left: 127px;
    font-family: calibri;
    background-position-y:1px;
}

table .app-title {
	font-size: 28px;
	font-weight: bold;
	display: inline-block;
}

.btn-login {
	width: 100%;
	font-size: 17px;
	font-weight: bold;
}
</style>
<%
	String path = request.getContextPath();
%>

</head>

<body>
	<form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<td><div class="company-name">| DRMS</div></td>
			</tr>
			<tr>
				<td><span><input type="text" name="j_username"
						class="form-control" id="j_username" placeholder="Username" /></span></td>
			</tr>
			<tr>
				<td><span><input type="password" name="j_password"
						class="form-control" id="j_password" placeholder="Password" /></span></td>
			</tr>
			<tr>
				<td><span><input type="submit" value="Log in"
						class="btn btn-primary btn-login"></span></td>
			</tr>
		</table>
	</form>
</body>
</html>