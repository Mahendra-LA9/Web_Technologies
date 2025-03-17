import java.io.*;
import java.util.HashMap;
import javax.servlet.*;

public class RegisterServlet extends GenericServlet {
    private static final HashMap<String, String> users = new HashMap<>(); // Temporary storage

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String department = req.getParameter("department");

        if (users.containsKey(email)) {
            out.println("<h3>Email already registered! Try logging in.</h3>");
        } else {
            users.put(email, password);
            out.println("<h3>Registration Successful! <a href='login.html'>Login Here</a></h3>");
        }
    }

    public static HashMap<String, String> getUsers() {
        return users;
    }
}
