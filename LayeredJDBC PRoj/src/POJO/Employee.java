package POJO;

import java.sql.*;
import java.sql.Date;

public class Employee {
	public int empId;
	public String name;
	public String addr;
	public double salary;
	public String deptid;
	public Date joinDate;
	
	public Employee(int id, String name,double sal,Date joindate)
	{
		this.empId = id;
		this.name = name;
		this.salary = sal;
		this.joinDate = joindate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr + ", salary=" + salary + ", deptid="
				+ deptid + ", joinDate=" + joinDate + "]";
	}
}
