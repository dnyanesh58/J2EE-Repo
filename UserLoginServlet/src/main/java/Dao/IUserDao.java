package Dao;

import java.sql.SQLException;

import Pojos.User;

public interface IUserDao 
{
	User authenticateUser(String email,String pass) throws SQLException;
}
