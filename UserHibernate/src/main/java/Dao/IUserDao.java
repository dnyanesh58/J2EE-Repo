package Dao;

import java.io.IOError;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import Pojos.Role;
import Pojos.User;

public interface IUserDao 
{
	String saveNewUser(User user);
	
	User getUserById(int Id);
	
	List<User> getAllUsers();
	
	List<User> getSelectedUsers(LocalDate strtDate,LocalDate endDate,Role role);
	
	User userLogin(String email,String pass);
	
	List<String> getSelUserNames(LocalDate date);
	
	User changePassword(String email,String oldpass,String newpass);
	
	String applyBulkDiscount(LocalDate date,double discount);
	
	String unSubscribeUser(int Id);
	
	String saveImage(int Id,String fileName) throws IOException;
	
	String readImage(int Id,String newfileName) throws IOException;
}
