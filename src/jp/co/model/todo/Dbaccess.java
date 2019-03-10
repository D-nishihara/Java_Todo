package jp.co.model.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class Dbaccess {

	public  DataSource Dbconnection(DataSource ds) throws ServletException {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:/comp/env/jdbc/SQLServer");
		} catch(Exception e) {

		}
		return ds;
	}

	public Userinformationdto Dbexistencecheck(String sql , String user , int psw) throws ServletException {
		DataSource ds = null;

		Userinformationdto userInformationDto = new Userinformationdto();

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user);
			pstmt.setInt(2, psw);
			try(ResultSet rset = pstmt.executeQuery();){
				while(rset.next()) {
				userInformationDto.setUserId(rset.getInt("user_id"));
				userInformationDto.setUser(rset.getString("user_name"));
				userInformationDto.setPsw(rset.getInt("user_password"));
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return userInformationDto;

	}


	public List<Usertaskdto> Dbtasklistget(String sql , Userinformationdto userInformationDto) throws ServletException {
		DataSource ds = null;

		List<Usertaskdto> userTaskList = new ArrayList<Usertaskdto>();

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, userInformationDto.getUserId());
			//pstmt.setString(2, userInformationDto.getUser());
			try(ResultSet rset = pstmt.executeQuery();){
				while (rset.next()) {
					Usertaskdto userTaskDto = new Usertaskdto();
					userTaskDto.setTaskNumber((rset.getInt("task_number")));
					userTaskDto.setTaskTitle(rset.getString("task_title"));
					userTaskDto.setTaskStartDate(rset.getDate("task_start_date"));
					userTaskDto.setTaskEndDate(rset.getDate("task_end_date"));
					userTaskDto.setTaskStatus(rset.getInt("task_status"));
					userTaskDto.setTaskDescription(rset.getString("task_description"));
					userTaskList.add(userTaskDto);
				}
			}
		}
			catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		return userTaskList;
	}

	public boolean Dbtasklistdelete(String sql,int userId,int taskNum) throws ServletException {
		DataSource ds = null;
		int sqlDelResult = 0;
		boolean bool = false;

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, userId);
			pstmt.setInt(2, taskNum);
			con.setAutoCommit(false);
			sqlDelResult = pstmt.executeUpdate();
			if (sqlDelResult == 1 ) {
				con.commit();
				bool = true;
			}
			else {
				con.rollback();
				bool = false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return bool;
	}

	//編集画面に遷移するときに設定するパラメータを取得
	public List<Usertaskdto> Dbtaskdetailsget(String sql , int userId,int taskNum) throws ServletException {
		DataSource ds = null;

		List<Usertaskdto> userTaskList = new ArrayList<Usertaskdto>();

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, userId);
			pstmt.setInt(2, taskNum);
			try(ResultSet rset = pstmt.executeQuery();){
				while (rset.next()) {
					Usertaskdto userTaskDto = new Usertaskdto();
					userTaskDto.setTaskNumber(rset.getInt("task_number"));
					userTaskDto.setTaskTitle(rset.getString("task_title"));
					userTaskDto.setTaskStartDate(rset.getDate("task_start_date"));
					userTaskDto.setTaskEndDate(rset.getDate("task_end_date"));
					userTaskDto.setTaskStatus(rset.getInt("task_status"));
					userTaskDto.setTaskDescription(rset.getString("task_description"));
					userTaskList.add(userTaskDto);
				}
			}
		}
			catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		return userTaskList;

		}

	public boolean Dbtaskupdate(String sql , int userId , Usertaskdto userTaskDto) throws ServletException {
		DataSource ds = null;
		int sqlDelResult = 0;
		boolean bool = false;

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, userTaskDto.getTaskTitle());
			pstmt.setDate(2, userTaskDto.getTaskStartDate());
			pstmt.setDate(3, userTaskDto.getTaskEndDate());
			pstmt.setInt(4, userTaskDto.getTaskStatus());
			pstmt.setString(5, userTaskDto.getTaskDescription());
			pstmt.setInt(6, userId);
			pstmt.setInt(7, userTaskDto.getTaskNumber());
			con.setAutoCommit(false);
			sqlDelResult = pstmt.executeUpdate();
			if (sqlDelResult == 1 ) {
				con.commit();
				bool = true;
			}
			else {
				con.rollback();
				bool = false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return bool;

	}

	public List<Integer> Dbuseridsearchlist(String userIdSearchListSql) throws ServletException {
		DataSource ds = null;

		DataSource sqlDs = Dbconnection(ds);
		List<Integer> userIdSearchList = new ArrayList<Integer>();

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(userIdSearchListSql)){
			try(ResultSet rset = pstmt.executeQuery();){
				while (rset.next()) {
					Userinformationdto userInformationDto = new Userinformationdto();
					userInformationDto.setUserId(rset.getInt("user_id"));
 					userIdSearchList.add(userInformationDto.getUserId());
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return userIdSearchList;

	}

	public void DbuserAccountRegistration(String userAccountRegistrationSql , int userLastId , Userinformationdto userInformationDto) throws ServletException {

		DataSource ds = null;

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(userAccountRegistrationSql)){
			pstmt.setInt(1, userLastId + 1);
			pstmt.setString(2, userInformationDto.getUser());
			pstmt.setInt(3, userInformationDto.getPsw());

			try(ResultSet rset = pstmt.executeQuery();){
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public List<Integer> Dbtasknumbersearch(String taskNumberSearchsql , int userId) throws ServletException{
		DataSource ds = null;

		DataSource sqlDs = Dbconnection(ds);
		List<Integer> userIdSearchList = new ArrayList<Integer>();

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(taskNumberSearchsql)){
			pstmt.setInt(1, userId);
			try(ResultSet rset = pstmt.executeQuery();){
				while (rset.next()) {
					Usertaskdto userTaskDto = new Usertaskdto();
					userTaskDto.setTaskNumber(rset.getInt("task_number"));
 					userIdSearchList.add(userTaskDto.getTaskNumber());
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return userIdSearchList;
	}

	public boolean Dbtaskadd(String sql , int userId , Usertaskdto userTaskDto , int userLastTaskNumber) throws ServletException {
		DataSource ds = null;
		int sqlDelResult = 0;
		boolean bool = false;

		DataSource sqlDs = Dbconnection(ds);

		try(Connection con = sqlDs.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userLastTaskNumber + 1);
			pstmt.setString(3, userTaskDto.getTaskTitle());
			pstmt.setDate(4, userTaskDto.getTaskStartDate());
			pstmt.setDate(5, userTaskDto.getTaskEndDate());
			pstmt.setInt(6, userTaskDto.getTaskStatus());
			pstmt.setString(7, userTaskDto.getTaskDescription());
			con.setAutoCommit(false);
			sqlDelResult = pstmt.executeUpdate();
			if (sqlDelResult == 1 ) {
				con.commit();
				bool = true;
			}
			else {
				con.rollback();
				bool = false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return bool;

	}

}
