package jp.co.logic.todo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import jp.co.model.todo.Dbaccess;
import jp.co.model.todo.Usertaskdto;

public class Taskoperationlogic {

	public boolean Taskdelete(int userId,int taskNum) {

		boolean bool = false;

		String sql = "delete from user_task_table where user_id = ? and task_number = ?";

		try {
			Dbaccess dbAccess = new Dbaccess();
			bool = dbAccess.Dbtasklistdelete(sql,userId,taskNum);

		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return bool;

	}

	public List<Usertaskdto> Usertaskdetailsget(int userId,int taskNum){

		List<Usertaskdto> userTaskDetails = null;

		String sql = "select task_number, task_title, task_start_date, task_end_date, task_status, task_description from user_table INNER JOIN user_task_table on user_task_table.user_id = ? where task_number = ?;";

		Dbaccess dbAccess = new Dbaccess();
		try {
			userTaskDetails = dbAccess.Dbtaskdetailsget(sql,userId,taskNum);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return userTaskDetails;

	}

	public boolean Taskupdate(int userId,Usertaskdto userTaskDto) {

		boolean bool = false;

		String sql = "update user_task_table set task_title = ? , task_start_date = ? , task_end_date = ? , task_status = ? , task_description = ? where user_id = ? and task_number = ?";

		Dbaccess dbAccess = new Dbaccess();
		try {
			bool = dbAccess.Dbtaskupdate(sql,userId,userTaskDto);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return bool;

	}

	public boolean Taskadd(int userId,Usertaskdto userTaskDto) {

		List<Integer> userTaskNumberSearchList = new ArrayList<Integer>();
		boolean bool = false;

		String taskNumberSearchsql = "select task_number from user_task_table where user_id = ? order by task_number";
		String taskAddInsertsql = "insert into user_task_table values(? , ? , ? , ? , ? , ? , ?)";

		Dbaccess dbAccess = new Dbaccess();
		try {
			userTaskNumberSearchList = dbAccess.Dbtasknumbersearch(taskNumberSearchsql , userId);
			int userLastTaskNumber = userTaskNumberSearchList.get(userTaskNumberSearchList.size() - 1);
			bool = dbAccess.Dbtaskadd(taskAddInsertsql,userId,userTaskDto,userLastTaskNumber);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return bool;
	}


}
