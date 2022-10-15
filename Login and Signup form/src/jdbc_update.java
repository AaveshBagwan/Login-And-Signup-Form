import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc_update {
    String name3, phone3, email3, address3, gender3, occupation3, str3, login_name, login_phone;
    PreparedStatement ppt;
    Connection conn;


    public void updated_values (String name3, String phone3, String email3, String address3, String gender3, String occupation3) {
        this.name3 = name3;
        this.phone3 = phone3;
        this.email3 = email3;
        this.address3 = address3;
        this.gender3 = gender3;
        this.occupation3 = occupation3;

    }

    public void update_from_this (Connection conn,String login_name,String login_phone){
        this.login_phone = login_phone;
        this.login_name = login_name;
        this.conn = conn;
    }

    public void update() {

        try {

            str3 = "update first_table set name = ?, email = ?, address = ?, phone = ?, gender = ?, occupation = ? where name = ? and phone = ? ";
            ppt = conn.prepareStatement(str3);
            ppt.setString(1,name3);
            ppt.setString(2,email3);
            ppt.setString(3,address3);
            ppt.setString(4,phone3);
            ppt.setString(5,gender3);
            ppt.setString(6,occupation3);
            ppt.setString(7,login_name);
            ppt.setString(8,login_phone);
            ppt.executeUpdate();
            System.out.println("Data Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
