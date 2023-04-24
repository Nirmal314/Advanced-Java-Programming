import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IncludeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h1>This is IncludeServlet</h1>");

        RequestDispatcher rd = req.getRequestDispatcher("/fs");
        rd.include(req, res);
    }
}
