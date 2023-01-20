package DAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import POJO.Employee;

public interface IEmployeeDao 
{
	List<Employee> getEmpDetailsByDeptAndDate(String deptid, Date joinDate) throws SQLException;
}
