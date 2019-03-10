package jp.co.controller.todo;

import java.io.IOException;
import java.sql.Date;
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

public class Usertaskedit extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		Usertaskdto userTaskDto = new Usertaskdto();
		Loginlogic loginLogic = new Loginlogic();
		Taskoperationlogic taskOperationLogic = new Taskoperationlogic();
		Userinformationdto userInformationDto = new Userinformationdto();

		HttpSession session = request.getSession();
		userInformationDto.setUserId((Integer) session.getAttribute("userId"));
		userInformationDto.setUser((String) session.getAttribute("user"));

		userTaskDto.setTaskNumber(Integer.parseInt(request.getParameter("edittasknumber")));
		userTaskDto.setTaskTitle(request.getParameter("edittaskname"));
		userTaskDto.setTaskDescription(request.getParameter("edittaskdescription"));
		userTaskDto.setTaskStartDate(Date.valueOf(request.getParameter("edittaskstartdate")));
		userTaskDto.setTaskEndDate(Date.valueOf(request.getParameter("edittaskenddate")));
		userTaskDto.setTaskStatus(Integer.parseInt(request.getParameter("edittaskstatus")));

		boolean bool =	 taskOperationLogic.Taskupdate(userInformationDto.getUserId(),userTaskDto);

		if (bool == true) {

			List<Usertaskdto> userTaskLists = loginLogic.Usertasklist(userInformationDto);
			request.setAttribute("tasklists", userTaskLists);
			request.getRequestDispatcher("/Loginsuccess.jsp").forward(request, response);

		}
		else if (bool = false) {

			List<Usertaskdto> userTaskLists = loginLogic.Usertasklist(userInformationDto);
			request.setAttribute("tasklists", userTaskLists);
			request.getRequestDispatcher("/Loginsuccess.jsp").forward(request, response);

		}



	}

}
