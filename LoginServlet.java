import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HashMap<String, String> users = RegisterServlet.getUsers();

        if (users.containsKey(email) && users.get(email).equals(password)) {
            HttpSession session = ((HttpServletRequest) req).getSession();
            session.setAttribute("user", email);
            ((HttpServletResponse) res).sendRedirect("HomeServlet");
        } else {
            out.println("<h3>Invalid Credentials! <a href='login.html'>Try Again</a></h3>");
        }
    }
}
