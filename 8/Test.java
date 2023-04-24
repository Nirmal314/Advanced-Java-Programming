import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Test extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext ctx = getServletContext();
        ServletConfig cfg = getServletConfig();

        String ctxp1 = ctx.getInitParameter("ctxp1");
        String ctxp2 = ctx.getInitParameter("ctxp2");

        String cfgp1 = cfg.getInitParameter("cfgp1");
        String cfgp2 = cfg.getInitParameter("cfgp2");

        out.println(
                "<h3>" + ctxp1 + "</h3><h3>" + ctxp2 + "</h3><h3>" + cfgp1 + "</h3><h3>" + cfgp2 + "</h3>");
    }
}
