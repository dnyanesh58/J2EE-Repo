package Pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.TutorialDaoImpl;

/*
 * TutorialsServlet
1. doGet
set cont type , pw
get session --tut dao
invoke method to get all tut names by specified topic id --List<String>
Iterate over the list --- send links : href=tut name 
 */
/**
 * Servlet implementation class TutorialsServlet
 */
@WebServlet("/tutorials")
public class TutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//get HttpSession from WC
			HttpSession hs=request.getSession();
			//get tut dao instance from the session scope
			TutorialDaoImpl tutDao=(TutorialDaoImpl)hs.getAttribute("tutorial_details");
			if(tutDao != null)
			{
				int topicId=Integer.parseInt(request.getParameter("topic_id"));
				for(String tutName : tutDao.getAllTutorials(topicId))
				{
					//dyn generation of links <a href=' tut_details ?tut_name= tutname >tut name </a>
					pw.print("<h5><a href='tut_details?tut_name="+tutName+"'> "+tutName+"</a></h5>");					
				}
			}else
				pw.print("No cookies ...no session tracking!!!!!!!!!!!!!!");
		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
