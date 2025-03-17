import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session != null) {
            session.invalidate();
        }

        out.println("<h3>You have been logged out. <a href='login.html'>Login Again</a></h3>");
    }
}
