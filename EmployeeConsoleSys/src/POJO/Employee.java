package POJO;

import java.sql.Date;

public class Employee 
{
	public int empId;
	public String empName;
	public String empAddr;
	public double empSal;
	public String deptId;
	public Date joinDate;
	
	public Employee(int empId, String empName, String empAddr, double empSal, String deptId, Date joinDate) 
	{
		this.empId = empId;
		this.empName = empName;
		this.empAddr = empAddr;
		this.empSal = empSal;
		this.deptId = deptId;
		this.joinDate = joinDate;
	}
	
	public Employee(String name, String address, double salary, String deptId, Date joinDate) {
		super();
		this.empName = name;
		this.empAddr = address;
		this.empSal = salary;
		this.deptId = deptId;
		this.joinDate = joinDate;
	}
	
	public Employee(int empId, String empName, double empSal, Date joinDate) 
	{
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.joinDate = joinDate;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddr=" + empAddr + ", empSal=" + empSal
				+ ", deptId=" + deptId + ", joinDate=" + joinDate + "]"+"\n";
	}
}
