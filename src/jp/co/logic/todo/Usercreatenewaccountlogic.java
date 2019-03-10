package jp.co.logic.todo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import jp.co.model.todo.Dbaccess;
import jp.co.model.todo.Userinformationdto;

public class Usercreatenewaccountlogic {

	public void Usercreatenewaccount(Userinformationdto userInformationDto) {

		List<Integer> userIdSearchList = new ArrayList<Integer>();

		String userIdSearchListSql = "select user_id from user_table order by user_id";
		String userAccountRegistrationSql = "insert into user_table values(? , ? , ?)";

		try {
			Dbaccess dbAccess = new Dbaccess();
			userIdSearchList = dbAccess.Dbuseridsearchlist(userIdSearchListSql);
			int userLastId = userIdSearchList.get(userIdSearchList.size() -1);
			dbAccess.DbuserAccountRegistration(userAccountRegistrationSql, userLastId, userInformationDto);

		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
