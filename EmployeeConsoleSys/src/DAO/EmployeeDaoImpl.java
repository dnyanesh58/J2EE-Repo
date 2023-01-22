package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Utils.DBUtils.*;
import POJO.Employee;

public class EmployeeDaoImpl implements IEmployeeDao
{
	
	private Connection cn ;
	private PreparedStatement ps,ps1,ps2,ps3,ps4;
	
	public EmployeeDaoImpl() throws SQLException
	{
		cn = getConnect();
		ps = cn.prepareStatement("select * from my_emp");
		ps1 = cn.prepareStatement("select empid,name,salary,join_date from my_emp"
				+ " where deptid = ? and join_date > ? order by salary");
		ps2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		ps3 = cn.prepareStatement("update my_emp set salary=salary+?,deptid=? where empid=?");
		ps4 = cn.prepareStatement("delete from my_emp where empid=?");
		System.out.println("Dao Created");
	}
	
	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		
		try(ResultSet rst = ps.executeQuery();)
		{
			while (rst.next()) 
			{
				list.add(new Employee(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4)
						,rst.getString(5),rst.getDate(6)));
			}
		}	
		return list;
	}

	@Override
	public List<Employee> getAllEmployeesByDeptAndDate(String deptid, Date joindate) throws SQLException 
	{
		List<Employee> list = new ArrayList<Employee>();
		ps1.setString(1, deptid);
		ps1.setDate(2, joindate);
		try(ResultSet rst = ps1.executeQuery();)
		{
			list.add(new Employee(rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4)));
		}
		return list;
	}

	@Override
	public String insertEmployee(Employee e) throws SQLException {
		ps2.setString(1, e.empName);
		ps2.setString(2, e.empAddr);
		ps2.setDouble(3, e.empSal);
		ps2.setString(4, e.getDeptId());
		ps2.setDate(5, e.getJoinDate());
		
		int updateCount = ps2.executeUpdate();
		if (updateCount == 1) 
		{
			return "Emp details inserted";
		}
		return "Emp details failed to insert";
	}

	@Override
	public String updateEmployee(double salIncr,String newDept, int empId) throws SQLException {
		ps3.setDouble(1, salIncr);
		ps3.setString(2, newDept);
		ps3.setInt(3, empId);
		
		int updateCount = ps3.executeUpdate();
		if (updateCount == 1) 
		{
			return "Emp details updated success";
		}
		return "Emp details updated failed";
	}

	@Override
	public String deleteEmployee(int empId) throws SQLException {
		ps4.setInt(1, empId);
		int updateCount = ps4.executeUpdate();
		if (updateCount == 1) 
		{
			return "Emp details deleted";
		}
		return "Emp details deleted failed";
	}
	
	public void cleanUp() throws SQLException
	{
		if (ps != null) 
			ps.close();
		if (ps1 != null) 
			ps.close();
		if (ps2 != null) 
			ps.close();
		if (ps3 != null) 
			ps.close();
		if (ps4 != null) 
			ps.close();
	}
}
