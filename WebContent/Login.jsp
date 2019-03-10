<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="Login.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="flexbox">
		<div class="flexheader">

		</div>
		<form action="/todo/todoconfirmation" method="POST">
			<div class="flexcontents">
				<input class="usertext" type="text" name="user" placeholder="ユーザー">

				<input class="pswtext" type="text" name="psw" placeholder="パスワード">
				<a href="/todo/Createnewaccount.jsp" >初めて利用する場合はこちら</a>

				<input class="loginbutton" type="submit" value="ログイン">
			</div>
		</form>
	</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>