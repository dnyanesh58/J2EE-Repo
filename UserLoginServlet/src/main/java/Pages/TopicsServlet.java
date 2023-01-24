package Pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.TopicDaoImpl;
import Pojos.Topic;
import Pojos.User;

@WebServlet(value="/topics", loadOnStartup = 1)
public class TopicsServlet extends HttpServlet
{
	public void init()
	{
		System.out.println("In topicservlet init ");
	}
	
	public void destroy()
	{
		System.out.println("In topicservlet destroy");
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException,ServletException
	{
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h4>Topics Page</h4>");
			
			HttpSession session = request.getSession();
			
			System.out.println("From topics page session is new "+session.isNew());
			
			System.out.println("Session Id "+session.getId());
			
			User user = (User) session.getAttribute("user_details");
			if (user != null	) 
			{
				pw.print("<h4>User details retrieved from a session</h4>"+user);
				
				TopicDaoImpl topicdao = (TopicDaoImpl) session.getAttribute("topic_details");
				
				pw.print("<form action='tutorials'>");
				for (Topic t : topicdao.getAllTopics())
					pw.print("<input type='radio' name='topic_id' value='" + t.getTopicId() + "'/>" + t.getTopicName()
							+ "<br/>");
				pw.print("<input type='submit' value='Choose Topic'/>");
				pw.print("</form>");
			}
			else 
			{
				pw.print("<h5> NO Cookies : Session Tracking Failed!!!!!!!!!!!!!!!</h5>");
			}
		/*	Cookie[] cookies = request.getCookies();
			if (cookies != null) 
			{
				for (Cookie cookie : cookies) 
				{
					if (cookie.getName().equals("user_details")) 
					{
						pw.print("<h4>User Details : </h4>"+cookie.getValue());
					}
				}
			}
			else 
			{
				pw.print("<h4>No Cookies : Session tracking failed</h4>");
			}*/
		}
		catch (Exception e) 
		{
			
		}
		
	}
}
