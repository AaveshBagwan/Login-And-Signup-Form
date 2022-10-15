import java.sql.*;

public class jdbc {
    Connection con;

    public Connection giveConnection() {
        String url  = "jdbc:mysql://localhost:3306/first_database";
        String user = "root";
        String password = "Aavej@7888";

        try {

//             Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established with database");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public void addActionListener(Account_details.After_confirm after_confirm) {
    }
}
