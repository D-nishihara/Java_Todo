package jp.co.controller.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import jp.co.logic.todo.Loginlogic;
import jp.co.model.todo.Userinformationdto;
import jp.co.model.todo.Usertaskdto;

public class Userconfirmation extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		String user = null;
		int psw = 0;

		try {
			user = request.getParameter("user");
			psw = Integer.parseInt(request.getParameter("psw"));

			if (!StringUtils.isEmpty(user) && psw != 0) {

				Loginlogic loginLogic = new Loginlogic();

				Userinformationdto userInformationDto = loginLogic.Userexistencecheck(user, psw);
				if (!StringUtils.isEmpty(userInformationDto.getUser()) && userInformationDto.getPsw() != 0) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					session.setAttribute("userId", userInformationDto.getUserId());
					List<Usertaskdto> userTaskLists = loginLogic.Usertasklist(userInformationDto);
					//request.setAttribute("user", userInformationDto.getUser());
					request.setAttribute("tasklists", userTaskLists);
					request.getRequestDispatcher("/Loginsuccess.jsp").forward(request, response);

				} else {

					request.getRequestDispatcher("/Login.jsp").forward(request, response);

				}
			}

			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} catch (Exception e) {

		}
	}
}
