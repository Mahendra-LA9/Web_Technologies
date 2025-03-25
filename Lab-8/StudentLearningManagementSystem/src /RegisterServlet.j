import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    // The doPost method must be inside the RegisterServlet class
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        // Get form parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String course = request.getParameter("course");

        // Create a new Student object
        Student student = new Student(name, email, password, course);

        // Get the ServletContext to store/retrieve shared data
        ServletContext context = getServletContext();

        // Retrieve the 'students' attribute from the ServletContext and ensure it's an ArrayList<Student>
        ArrayList<Student> students = null;
        Object attribute = context.getAttribute("students");

        if (attribute instanceof ArrayList<?>) {
            students = (ArrayList<Student>) attribute;
        } else {
            students = new ArrayList<>();
        }

        // Add the new student to the list
        students.add(student);

        // Store the updated list of students back in the ServletContext
        context.setAttribute("students", students);

        // Redirect the user to the login page after registration
        response.sendRedirect("login.html");
    }
}
