import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.print("<h1>Servlet tested!</h1>");
    }
}
