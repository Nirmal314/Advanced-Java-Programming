import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Prac3 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "nemo", "123");
            Statement s = c.createStatement();

            // Create database
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS mydb");
            s.executeUpdate("USE mydb");

            // Create table
            s.executeUpdate("CREATE TABLE IF NOT EXISTS mytable (id INT, name VARCHAR(255))");

            // Insert record
            s.executeUpdate("INSERT INTO mytable (id, name) VALUES (1, 'person1')");
            s.executeUpdate("INSERT INTO mytable (id, name) VALUES (2, 'person2')");

            // Update record
            s.executeUpdate("UPDATE mytable SET name = 'person3' WHERE id = 2");

            // Delete record
            s.executeUpdate("DELETE FROM mytable WHERE name = 'person1'");

            // Delete table
            s.executeUpdate("DROP TABLE IF EXISTS mytable");

            // Delete database
            s.executeUpdate("DROP DATABASE IF EXISTS mydb");

            s.close();
            c.close();
        } catch (Exception e) {
            return;
        }

    }
}
