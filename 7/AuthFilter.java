import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No initialization required
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hres = (HttpServletResponse) res;

        HttpSession session = hreq.getSession(false);
        if (session != null && session.getAttribute("authenticated") != null
                && (Boolean) session.getAttribute("authenticated")) {
            chain.doFilter(req, res);
        } else {
            hres.sendRedirect(hreq.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {
        // No cleanup required
    }
}
