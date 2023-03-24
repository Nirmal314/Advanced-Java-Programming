import java.sql.*;

public class Scrollable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123");
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        rs.last();

        System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ": " + rs.getDouble("salary"));

        rs.first();

        System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ": " + rs.getDouble("salary"));

        rs.absolute(2);

        System.out.println(rs.getInt("id") + ": " + rs.getString("name") + ": " + rs.getDouble("salary"));
    }
}

// 3: person 3: 30000.0
// 1: person 1: 10000.0
// 2: person 2: 20000.0