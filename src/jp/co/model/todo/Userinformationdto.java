package jp.co.model.todo;

import java.io.Serializable;

public class Userinformationdto implements Serializable {
    // static final long serialVersionUIDが必要
    private static final long serialVersionUID = 1L;

	private int userId;

	private String user;

	private int psw;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPsw() {
		return psw;
	}

	public void setPsw(int psw) {
		this.psw = psw;
	}
}
