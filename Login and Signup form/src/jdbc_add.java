import java.sql.*;

public class jdbc_add {
    public jdbc_add(Connection con2, String name1, String email1, String address1, String phone1,
                    String gender1 ,String occupation1 ) {

//        (name, email, address, phone, gender, occupation )
        String str = "INSERT INTO first_table VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement query = con2.prepareStatement(str);
            query.setString(1,name1);
            query.setString(2,email1);
            query.setString(3,address1);
            query.setString(4,phone1);
            query.setString(5,gender1);
            query.setString(6,occupation1);
            boolean rset = query.execute();
            System.out.println("Data added successfully !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
