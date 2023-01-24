package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Utils.DBUtils.*;

import Pojos.User;

public class UserDaoImpl implements IUserDao
{

	private Connection cn;
	private PreparedStatement pst;
	
	public UserDaoImpl() throws SQLException
	{
		cn = getConnect();
		pst = cn.prepareStatement("select * from users where email = ? and password = ?");
		System.out.println("In UserDaoImpl");
	}
	
	
	public User authenticateUser(String email, String pass) throws SQLException 
	{
		
		pst.setString(1, email);
		pst.setString(2, pass);
		
		try(ResultSet rst = pst.executeQuery();)
		{
			if (rst.next()) 
			{
				return new User(rst.getInt(1),rst.getString(2),email,pass,
						rst.getDouble(5),rst.getDate(6),rst.getString(7));
			}
		}
		return null;
	}
	
	public void cleanUp() throws SQLException
	{
		if (pst != null) 
		{
			pst.close();
		}
		System.out.println("user dao cleaned up");
	}
}
