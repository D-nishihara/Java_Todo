package jp.co.controller.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.logic.todo.Loginlogic;
import jp.co.logic.todo.Taskoperationlogic;
import jp.co.model.todo.Userinformationdto;
import jp.co.model.todo.Usertaskdto;

public class Usertaskdelete extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{

		request.setCharacterEncoding("UTF-8");

		Usertaskdto userTaskDto;
		Userinformationdto userInformationDto = new Userinformationdto();

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		String user = (String) session.getAttribute("user");
		userInformationDto.setUserId(userId);
		userInformationDto.setUser(user);
		Integer taskNum = Integer.parseInt(request.getParameter("tasknum"));
		Integer taskSts = Integer.parseInt(request.getParameter("tasksts"));

		Taskoperationlogic taskOperationLogic = new Taskoperationlogic();

		if (request.getParameter("edit") != null) {

			List<Usertaskdto> userTaskDetails = taskOperationLogic.Usertaskdetailsget(userId, taskNum);

			request.setAttribute("taskdetails", userTaskDetails);

			request.getRequestDispatcher("/Taskedit.jsp").forward(request, response);

		}
		else if (request.getParameter("delete") != null){

			Loginlogic loginLogic = new Loginlogic();

			boolean bool =taskOperationLogic.Taskdelete(userId, taskNum);

			if (bool == true) {

				List<Usertaskdto> userTaskLists = loginLogic.Usertasklist(userInformationDto);

				request.setAttribute("tasklists", userTaskLists);

				request.getRequestDispatcher("/Loginsuccess.jsp").forward(request, response);
			}
			else {

				List<Usertaskdto> userTaskLists = loginLogic.Usertasklist(userInformationDto);

				request.setAttribute("tasklists", userTaskLists);

				request.getRequestDispatcher("/Loginsuccess.jsp").forward(request, response);
			}
		}
	}

}
