import java.sql.*;

public class Updatable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123");

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ": " + rs.getDouble("salary"));
        }
        rs.moveToInsertRow();
        rs.updateInt("id", 5);
        rs.updateString("name", "person 5");
        rs.updateDouble("salary", 50000);
        rs.insertRow();

        rs.absolute(2);
        rs.deleteRow();

        rs.beforeFirst();

        while (rs.next()) {
            System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ": " + rs.getDouble("salary"));
        }

        rs.close();
        stmt.close();
        conn.close();

    }
}
// 1: person 1: 10000.0
// 2: person 2: 20000.0
// 3: person 3: 30000.0
// 1: person 1: 10000.0
// 3: person 3: 30000.0
// 5: person 5: 50000.0