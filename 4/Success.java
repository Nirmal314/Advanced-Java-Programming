import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Success extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Cookie[] cookies = req.getCookies();

        out.print("<h1>You have been logged in</h1><br><h3>Cookie: " + cookies[0].getName() + "</h3>");
    }
}
