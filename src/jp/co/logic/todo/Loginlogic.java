package jp.co.logic.todo;

import java.util.List;

import javax.servlet.ServletException;

import jp.co.model.todo.Dbaccess;
import jp.co.model.todo.Userinformationdto;
import jp.co.model.todo.Usertaskdto;

public class Loginlogic {

	//ログイン時の認証チェックを行う
	public Userinformationdto Userexistencecheck(String user,int psw) {

		Userinformationdto userInformationDto = null;

		String sql = "select user_id, user_name, user_password from user_table where user_name = ? and user_password = ?;";

		try {
			Dbaccess dbAccess = new Dbaccess();
			userInformationDto = dbAccess.Dbexistencecheck(sql,user,psw);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return userInformationDto;
	}

	//ログイン成功時のタスクリスト表示処理を記載
	public List<Usertaskdto> Usertasklist(Userinformationdto userInformationDto) {

		List<Usertaskdto> userTaskLists = null;

		//String sql = "select task_number, task_title, task_start_date, task_end_date, task_status, task_description from user_table INNER JOIN user_task_table on user_task_table.user_id = ? where user_name = ?;";
		String sql = "select task_number, task_title, task_start_date, task_end_date, task_status, task_description from user_task_table where user_id = ?";


		try {
			Dbaccess dbAccess = new Dbaccess();
			userTaskLists = dbAccess.Dbtasklistget(sql,userInformationDto);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return userTaskLists;

	}
}
