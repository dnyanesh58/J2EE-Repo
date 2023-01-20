package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static Utils.DBUtils.openConnection;
import POJO.Employee;

public class EmployeeDaoImple implements IEmployeeDao
{
	
	private Connection cn;
	private PreparedStatement pst1;
	
	public EmployeeDaoImple() throws SQLException
	{
		cn = openConnection();
		String query = " select empid,name,salary,join_date from my_emp where deptid = ? and join_date > ? order by salary";
		pst1 =  cn.prepareStatement(query);
	}

	@Override
	public List<Employee> getEmpDetailsByDeptAndDate(String deptid, Date joinDate) throws SQLException 
	{
		List<Employee> empList = new ArrayList<Employee>();
		
		pst1.setString(1, deptid);
		pst1.setDate(2, joinDate);
		
		try(ResultSet rst = pst1.executeQuery();)
		{
			while (rst.next()) 
			{
				empList.add(new Employee(rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4)));
			}
		}
		return empList;
	}
	
	public void cleanup() throws SQLException
	{
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
	}
}
