<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="jp.co.model.todo.Usertaskdto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="Taskedit.css" rel="stylesheet">
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
	<%
		List<Usertaskdto> list = (List<Usertaskdto>)request.getAttribute("taskdetails");
	%>
	<div class="flexmain">
		<div class="flexcontents">
			<form action="/todo/todoedit" method="POST">
				<ul>
					<li>
						<input type="hidden" name="edittasknumber" value=<%=list.get(0).getTaskNumber() %>>
					</li>
					<li class="taskname">
						<label>■件名：</label>
						<input type="text" name="edittaskname" value=<%=list.get(0).getTaskTitle() %>>
					</li>
					<li class="taskdescription">
						<label>■備考：</label>
						<%
							String taskDescription = list.get(0).getTaskDescription();
							if (taskDescription == null) {
						%>
							<textarea rows="10" cols="100" name="edittaskdescription" placeholder="タスクに備考を記載したい場合、ここに記載してください。" ></textarea>
						<%
							}
						%>
						<%
							if (taskDescription != null) {
						%>
						<textarea rows="10" cols="100" name="edittaskdescription" >value=<%=list.get(0).getTaskDescription() %></textarea>
						<%
							}
						%>
					</li>
					<li class="taskstartdate">
						<label>■開始時期：</label>
						<input type="text" name="edittaskstartdate" value=<%=list.get(0).getTaskStartDate() %>>
					</li>
					<li class="taskenddate">
						<label>■終了時期：</label>
						<input type="text" name="edittaskenddate" value=<%=list.get(0).getTaskEndDate() %>>
					</li>
					<li class="taskstatus">
						<label>■状態：</label>
						<%
							int taskStatus = list.get(0).getTaskStatus();
							if (taskStatus == 0){
						%>
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> checked="checked">未完了
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >実施中
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >完了
						<%
							}
						%>
						<%
							if (taskStatus == 1){
						%>
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >未完了
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> checked="checked">実施中
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >完了
						<%
							}
						%>
						<%
							if (taskStatus == 2){
						%>
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >未完了
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> >実施中
						<input type="radio" name="edittaskstatus" value=<%=list.get(0).getTaskStatus() %> checked="checked">完了
						<%
							}
						%>
					</li>
					<li class="flexfooter">
						<input type="submit" value="キャンセル">
						<input type="submit" value="更新">
					</li>
				</ul>
			</form>
		</div>
	</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>