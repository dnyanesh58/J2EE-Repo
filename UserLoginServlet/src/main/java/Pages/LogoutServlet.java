package Pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Pojos.User;

/**
 * Servlet implementation class LogoutServlet
 */
/*
 * http://localhost:8080/day5_cms/logout doGet set cont type , pw get
 * HttpSession get user details from session send dyn resp --greeting Hello ,
 * user name session.invalidate() visit again --> login page
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession hs = request.getSession();
			System.out.println("in logout page " + hs.isNew());// false provided cookies are available
			System.out.println("session id " + hs.getId());// same jsessionid for the same clnt : provided cookies are
															// available
			// get user details from HS
			User user = (User) hs.getAttribute("user_details");
			if (user != null) {
				pw.print("<h5> Hello , " + user.getName() + "</h5>");
				pw.print("<h5> You have logged out....</h5>");

			} else
				pw.print("No cookies ...no session tracking!!!!!!!!!!!!!!");
			// discard either newly created (in case of blocked cookies) or existing(in case
			// of accepted cookies) HttpSession obj from server side heap
			hs.invalidate();
			// visit again link
			pw.print("<h5> <a href='login.html'>Visit Again</a></h5>");

		}
	}

}
