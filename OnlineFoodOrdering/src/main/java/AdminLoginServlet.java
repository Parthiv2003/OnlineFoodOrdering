import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		AdminLoginJdbc alj = new AdminLoginJdbc();
		
		if(alj.CheckUser(user, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",user);
			response.sendRedirect("home.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("error",true);
			response.sendRedirect("adminLogin.jsp");
		}
	}
}
