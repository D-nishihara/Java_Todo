<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="jp.co.model.todo.Usertaskdto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="Loginsuccess.css" rel="stylesheet">
<title>Insert title here</title>
</head>

<body>
	<header>
		<div class="flexheader">
			<div class="headertitle">ToDoリスト</div>
			<div class="headermain">現在のタスク一覧です。</div>
			<div class="headeruser">ログイン中：<%=session.getAttribute("user") %>さん</div>
			<a href="/todo/Newtaskadd.jsp">タスク追加</a>
		</div>
	</header>
	<div class="flexbox">
		<div class="flexcontents">
			<table border="1"class="tablelayout" id="tableid">
				<tr align="center">
					<th width="10px">No.</th>
					<th width="150px">タイトル</th>
					<th width="80px">開始時期</th>
					<th width="80px">終了時期</th>
					<th width="50px">状態</th>
					<th width="60px">-</th>
					<th width="60px">-</th>
				</tr>
				<%
					int rowcount = 1;
					List<Usertaskdto> lists = (List<Usertaskdto>)request.getAttribute("tasklists");
					for (Usertaskdto list : lists){
				%>
					<tr>
						<form action="/todo/tododelete" method="POST">
						<td><input type="hidden" name="tasknum" value=<%=list.getTaskNumber() %>><%=list.getTaskNumber() %></td>
						<td><input type="hidden" name="tasktit" value=<%=list.getTaskTitle() %>><%=list.getTaskTitle() %></td>
						<td><input type="hidden" name="taskstdt" value=<%=list.getTaskStartDate() %>><%=list.getTaskStartDate() %></td>
						<td><input type="hidden" name="taskeddt" value=<%=list.getTaskEndDate() %>><%=list.getTaskEndDate() %></td>
						<%
							int taskStatus = list.getTaskStatus();
							if (taskStatus == 0) {
						%>
						<td><input type="hidden" name="tasksts" value=<%=list.getTaskStatus() %>>未完了</td>
						<%
							}
						%>
						<%
							if (taskStatus == 1) {
						%>
						<td><input type="hidden" name="tasksts" value=<%=list.getTaskStatus() %>>実施中</td>
						<%
							}
						%>
						<%
							if (taskStatus == 2) {
						%>
						<td><input type="hidden" name="tasksts" value=<%=list.getTaskStatus() %>>完了</td>
						<%
							}
						%>
						<td><input type="submit" class="editbutton" name="edit" value="編集"></td>
						<td><input type="submit" class="deletebutton" name="delete" value="削除"></td>
						</form>
					</tr>
					<%
						}
					%>
			</table>
		</div>
	</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="Loginsuccess.js"></script>
</body>
</html>