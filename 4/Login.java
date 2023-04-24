import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    private static final HashMap<String, String> USERS = new HashMap<>();
    static {
        // Dummy user data for demonstration
        USERS.put("user1", "password1");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String un = req.getParameter("un");
        String pass = req.getParameter("pass");

        if (USERS.containsKey(un) && USERS.get(un).equals(pass)) {
            HttpSession s = req.getSession(true);
            s.setAttribute("un", un);

            Cookie c = new Cookie("username", un);
            c.setMaxAge(60 * 60 * 24 * 7);
            res.addCookie(c);

            res.sendRedirect("success");
        } else {
            out.print("<h1>Error: Invalid username or password</h1>");
        }
    }
}
