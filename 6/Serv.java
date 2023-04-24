import javax.servlet.*;
import javax.servlet.http.*;

public class Serv extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException {
        throw new ServletException("Something went wrong");
    }
}
