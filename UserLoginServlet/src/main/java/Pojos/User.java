package Pojos;

import java.sql.Date;

public class User 
{
	private int userid;
	private String name;
	private String email;
	private String password;
	private double regAmount;
	private Date regDate;
	private String role;
	
	public User()
	{
		
	}
	
	public User(String email, String password) 
	{
		this.email = email;
		this.password = password;
	}

	public User(int userid, String name, String email, String password, double regAmount, Date regDate, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + ", role=" + role + "]\n";
	}
	
	
}
