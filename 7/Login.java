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
        String un = req.getParameter("un");
        String pass = req.getParameter("pass");

        if (USERS.containsKey(un) && USERS.get(un).equals(pass)) {
            HttpSession s = req.getSession();
            s.setAttribute("authenticated", true);
            res.sendRedirect(req.getContextPath() + "/home.html");
        } else {
            res.sendRedirect(req.getContextPath() + "/login.html?error=true");
        }
    }
}
