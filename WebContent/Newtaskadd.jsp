<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="jp.co.model.todo.Usertaskdto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="Newtaskadd.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="flexheader">
			<div class="headertitle">タスク追加</div>
			<div class="headermain">下記項目に入力してください</div>
			<div class="headeruser">ログイン中：<%=request.getAttribute("user") %>さん</div>
		</div>
	</header>
	<div class="flexmain">
		<div class="flexcontents">
			<form action="/todo/usertaskadd" method="POST">
				<ul>
					<li class="taskname">
						<label>■件名：</label>
						<input type="text" name="taskaddname" >
					</li>
					<li class="taskdescription">
						<label>■備考：</label>
							<textarea rows="10" cols="100" name="taskadddescription" placeholder="タスクに備考を記載したい場合、ここに記載してください。" ></textarea>
					</li>
					<li class="taskstartdate">
						<label>■開始時期：</label>
						<input type="text" name="taskaddstartdate" >
					</li>
					<li class="taskenddate">
						<label>■終了時期：</label>
						<input type="text" name="taskaddenddate" >
					</li>
					<li class="taskstatus">
						<label>■状態：</label>
						<input type="radio" name="taskaddstatus" value="0" checked="checked">未完了
						<input type="radio" name="taskaddstatus" value="1" >実施中
						<input type="radio" name="taskaddstatus" value="2" >完了
					</li>
					<li class="flexfooter">
						<input type="submit" value="キャンセル">
						<input type="submit" value="登録">
					</li>
				</ul>
			</form>
		</div>
	</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>