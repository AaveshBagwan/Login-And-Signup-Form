

import java.sql.*;

public class jdbc_delete {

    Connection con3;
    String name13;
    String phone13;
    PreparedStatement ptt;

    public jdbc_delete(Connection con3,String name13,String phone13) {
        this.name13 = name13;
        this.phone13 = phone13;
        this.con3 = con3;
    }

    public void delete_account(){

        try{
            String str5 = "DELETE FROM first_table WHERE name = ? AND phone = ?";
            ptt = con3.prepareStatement(str5);
            ptt.setString(1,name13);
            ptt.setString(2,phone13);
            ptt.execute();
            System.out.println("Your Account name : "+ name13 +" phone : " + phone13 +" Is Succsfully Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}