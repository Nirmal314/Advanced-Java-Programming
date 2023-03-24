import java.io.*;
import java.sql.*;

public class Proc {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo",
                "123")) {

            String createInsertProc = "CREATE PROCEDURE InsertEmployee(IN eid INT, IN nm VARCHAR(50), IN sl DOUBLE) "
                    +
                    "BEGIN " +
                    "INSERT INTO employee (id, name, salary) VALUES(eid, nm, sl); " +
                    "END";
            PreparedStatement stmt1 = conn.prepareStatement(createInsertProc);
            stmt1.execute();

            String createGetSalaryProc = "CREATE PROCEDURE GetSalary(IN eid INT, OUT sl VARCHAR(255)) " +
                    "BEGIN " +
                    "SELECT salary INTO sl FROM employee WHERE id = eid; " +
                    "END";
            PreparedStatement stmt2 = conn.prepareStatement(createGetSalaryProc);
            stmt2.execute();

            CallableStatement stmt3 = conn.prepareCall("{CALL InsertEmployee(?,?,?)}");
            stmt3.setInt(1, 3);
            stmt3.setString(2, "person 3");
            stmt3.setDouble(3, 30000);
            stmt3.execute();

            // 4) Call the stored procedure to retrieve salary for given employee id
            CallableStatement stmt4 = conn.prepareCall("{CALL GetSalary(?,?)}");
            stmt4.setInt(1, 2);
            stmt4.registerOutParameter(2, Types.DOUBLE);
            stmt4.execute();
            System.out.println("Employee salary: " + stmt4.getString(2));

        } catch (SQLException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
        }

    }
}

// Employee salary: 20000