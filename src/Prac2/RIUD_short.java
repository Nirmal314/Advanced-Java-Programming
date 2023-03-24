package Prac2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class RIUD_short {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123");
        Statement stmt = conn.createStatement();

        // ! select
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("rollno") + ": " + rs.getString("name") + ": " + rs.getString("address"));
        }
        // ! insert
        for (int i = 3; i <= 4; i++) {
            stmt.execute(
                    "INSERT INTO student (rollno, name, address) VALUES (" + i + ", 'person " + i + "', 'address " + i
                            + "')");
        }

        // ! update
        stmt.execute("UPDATE student SET name='another name' WHERE rollno = 3");

        // ! delete
        stmt.execute("DELETE FROM student WHERE rollno = 1");

        // ! select fire
        ResultSet rs2 = stmt.executeQuery("SELECT * FROM student");
        while (rs2.next()) {
            System.out.println(
                    rs2.getInt("rollno") + ": " + rs2.getString("name") + ": " + rs2.getString("address"));
        }
    }
}
