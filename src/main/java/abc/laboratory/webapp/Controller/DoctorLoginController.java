package abc.laboratory.webapp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doctorLoginController")	
public class DoctorLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 String username = request.getParameter("username");
		        String password = request.getParameter("password");

		       
		        if ("Admin".equals(username) && "doc".equals(password)) {
		            
		            response.sendRedirect("LabWorkerHomePage.jsp");
		        } else {
		          
		            request.setAttribute("errorMessage", "Invalid username or password");
		            request.getRequestDispatcher("DoctorLogin.jsp").forward(request, response);
		        }
		    }

	}


