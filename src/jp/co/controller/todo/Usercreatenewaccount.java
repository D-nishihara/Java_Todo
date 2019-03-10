package jp.co.controller.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.logic.todo.Usercreatenewaccountlogic;
import jp.co.model.todo.Userinformationdto;

public class Usercreatenewaccount extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		Userinformationdto userInformationDto = new Userinformationdto();
		Usercreatenewaccountlogic userCreateNewAccountLogic = new Usercreatenewaccountlogic();

		userInformationDto.setUser(request.getParameter("user"));
		userInformationDto.setPsw(Integer.parseInt(request.getParameter("psw")));

		userCreateNewAccountLogic.Usercreatenewaccount(userInformationDto);

		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
}
