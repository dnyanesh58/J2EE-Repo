package Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.TopicDaoImpl;
import Dao.TutorialDaoImpl;
import Dao.UserDaoImpl;
import Pojos.User;

import static Utils.DBUtils.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/validate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet
{
	private UserDaoImpl userdao;
	private TopicDaoImpl topicdao;
	private TutorialDaoImpl tutdao;
	
	public void init() throws ServletException 
	{
		try 
		{
			openConnection();
			
			userdao = new UserDaoImpl();
			topicdao = new TopicDaoImpl();
			tutdao = new TutorialDaoImpl();
			
		} 
		catch (Exception e) 
		{
			throw new ServletException("err in init "+getClass().getName(),e);
		}
	}
	
	public void destroy() 
	{
		try 
		{
			closeConnection();
			userdao.cleanUp();
			topicdao.cleanUp();
			tutdao.cleanUp();
		}
		catch (Exception e) 
		{
			throw new RuntimeException("err in destroy"+getClass().getName(),e);
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
	{
		System.out.println("In doPost of "+getClass().getName());
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			
			User user = userdao.authenticateUser(email, pass);
			
			if (user == null) 
			{
				pw.print("<h4> Invalid Login Details <a href='login.html'>Retry</a></h4>");
			}
			else
			{
				pw.print("<h4>Login Successful</h4>");
				/*
				 * Cookie c1 = new Cookie("user_details",user.toString());
				 * 
				 * response.addCookie(c1);
				 */
				
				HttpSession hs = request.getSession();
				System.out.println("From login page : "+hs.isNew());
				System.out.println("Session Id : "+hs.getId());
				System.out.println("Session creation time : "+new Date(hs.getCreationTime()));
				
				hs.setAttribute("user_details", user);
				hs.setAttribute("topic_details",topicdao);
				hs.setAttribute("tutorial_details", tutdao);
				
				response.sendRedirect("topics");
			}
		}
		catch (Exception e) 
		{
			throw new ServletException("err in doPost of "+getClass().getName(),e);
		}
	}
}
