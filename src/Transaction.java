import java.sql.*;

public class Transaction {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123");

        // conn.createStatement().executeUpdate("CREATE TABLE bank_account (id INT
        // PRIMARY KEY, balance DOUBLE)");

        // PreparedStatement insert_stmt = conn.prepareStatement("INSERT INTO bank_account (id, balance) VALUES (?, ?)");

        // for (int i = 1; i <= 2; i++) {
        //     insert_stmt.setInt(1, i);
        //     insert_stmt.setDouble(2, i * 1000);
        //     insert_stmt.execute();
        // }

        // conn.setAutoCommit(false);

        // // PreparedStatement transfer_stmt = conn
        // // .prepareStatement("UPDATE bank_account SET balance = balance - ? WHERE id = ?");

        // // transfer_stmt.setDouble(1, 50);
        // // transfer_stmt.setInt(2, 1);
        // // transfer_stmt.execute();

        // PreparedStatement update_stmt = conn
        // .prepareStatement("UPDATE bank_account SET balance = balance + ? WHERE id = ?");
        // update_stmt.setDouble(1, 50);
        // update_stmt.setInt(2, 2);
        // update_stmt.execute();

        // conn.commit();

        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employee");
        while (rs.next()) {
        System.out.println(rs.getInt("id") + ": " + rs.getDouble("balance"));
        }

    }
}
