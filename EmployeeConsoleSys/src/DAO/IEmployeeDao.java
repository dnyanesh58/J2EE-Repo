package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import POJO.Employee;

public interface IEmployeeDao 
{
	List<Employee> getAllEmployee() throws SQLException;
	
	List<Employee> getAllEmployeesByDeptAndDate(String deptid,Date joindate) throws SQLException;
	
	String insertEmployee(Employee e) throws SQLException;
	
	String updateEmployee(double salIncr,String newDept,int empId) throws SQLException;
	
	String deleteEmployee(int empId) throws SQLException;
}
