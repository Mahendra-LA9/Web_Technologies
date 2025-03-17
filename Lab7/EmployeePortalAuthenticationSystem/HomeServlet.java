import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HomeServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            out.println("<h3>Access Denied! <a href='login.html'>Login</a></h3>");
        } else {
            String email = (String) session.getAttribute("user");
            out.println("<h2>Welcome, " + email + "!</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        }
    }
}
