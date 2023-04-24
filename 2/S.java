import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        BufferedReader br = new BufferedReader(new FileReader("/home/nemo/Desktop/Data/sample.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
        }

        br.close();
    }
}
