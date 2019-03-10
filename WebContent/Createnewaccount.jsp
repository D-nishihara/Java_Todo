<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="jp.co.model.todo.Usertaskdto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="Createnewaccount.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="flexbox">
		<div class="flexheader">

		</div>
			<div class="flexcontents">
				<form action="/todo/todousercreatenewaccount" method="POST">
					<div class="flexcontents">
						<input class="usertext" type="text" name="user" size="30" placeholder="登録するユーザーを入力してください。">

						<input class="pswtext" type="text" name="psw" size="30" placeholder="登録するパスワードを入力してください。">

						<input class="loginbutton" type="submit" value="登録">
					</div>
				</form>
			</div>
	</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>