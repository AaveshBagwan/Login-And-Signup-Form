import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc_select {
    String  name5;
    String phone5;
    jdbc j;
    Connection con4;
    PreparedStatement pt;
    ResultSet r;
    String Your_name1 ;
    String Your_phone1 ;
    String Your_email1 ;
    String Your_address1 ;
    String Your_gender1 ;
    String Your_occupation1 ;


    public jdbc_select(String  name5, String phone5) throws SQLException {
        this.name5=name5;
        this.phone5=phone5;

    }

    public int check(){

        int i = 0;
        try{

            j = new jdbc();
            con4 = j.giveConnection();
//            AND phone = '?'
            String str1 = "SELECT * FROM first_table WHERE name = ? AND phone = ? ";
            System.out.println("query : "+str1);
            pt = con4.prepareStatement(str1);
            pt.setString(1,name5);
            pt.setString(2,phone5);
            r = pt.executeQuery();

            while(r.next()){
                Your_name1 = r.getString(1);
                Your_phone1 = r.getString(4);
                Your_email1 = r.getString(2);
                Your_address1 = r.getString(3);
                Your_gender1 = r.getString(5);
                Your_occupation1 = r.getString(6);
                System.out.println( "name : "+ r.getString(1)+"\n"
                        +"phone : "+r.getString(4)+"\n"
                        +"email : "+r.getString(2)+"\n"
                        +"address"+r.getString(3)+"\n"
                        +"gender"+r.getString(5)+"\n"
                        +"occupation"+r.getString(6)+"\n");
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public String getYour_name1() {
        return Your_name1;
    }

    public String getYour_phone1() {
        return Your_phone1;
    }

    public String getYour_email1() {
        return Your_email1;
    }

    public String getYour_address1() {
        return Your_address1;
    }

    public String getYour_gender1() {
        return Your_gender1;
    }

    public String getYour_occupation1() {
        return Your_occupation1;
    }


}
