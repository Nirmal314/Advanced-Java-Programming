package Prac2;

import java.sql.*;

public class RUID_pstmt_short {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123");

        // ! select
        PreparedStatement stmt_select = conn.prepareStatement("SELECT * FROM student where rollno = ?");
        stmt_select.setString(1, "1");
        ResultSet rs = stmt_select.executeQuery();
        while (rs.next()) {
            System.out.println(
                    rs.getInt("rollno") + ": " + rs.getString("name") + ": " + rs.getString("address"));
        }

        // ! insert
        PreparedStatement stmt_insert = conn
                .prepareStatement("INSERT INTO student (rollno, name, address) VALUES (?, ?, ?)");

        for (int i = 3; i <= 4; i++) {
            stmt_insert.setString(1, String.valueOf(i));
            stmt_insert.setString(2, "person " + i);
            stmt_insert.setString(3, "address" + i);
            stmt_insert.execute();
        }

        // ! update
        PreparedStatement stmt_update = conn.prepareStatement("UPDATE student SET name = ? WHERE rollno = ?");

        stmt_update.setString(1, "updated name");
        stmt_update.setString(2, "3");

        stmt_update.execute();

        // ! delete
        String DELETE_QUERY = "DELETE FROM student WHERE rollno = ?";
        PreparedStatement stmt_delete = conn.prepareStatement(DELETE_QUERY);
        stmt_delete.setString(1, "2");
        stmt_delete.execute();

        // ! select
        PreparedStatement stmt_select2 = conn.prepareStatement("SELECT * FROM student where rollno = ?");
        stmt_select2.setString(1, "3");
        ResultSet rs2 = stmt_select2.executeQuery();
        while (rs2.next()) {
            System.out.println(
                    rs2.getInt("rollno") + ": " + rs2.getString("name") + ": " + rs2.getString("address"));
        }
    }
}
