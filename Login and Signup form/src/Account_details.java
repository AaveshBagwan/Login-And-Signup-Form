import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Account_details {
    JPanel panel_login, panel_account;
    JLabel name, phone, email, address, gender, occupation, title;
    JTextField Your_name, Your_phone, Your_email, Your_gender, Your_occupation;
    JTextField Your_address;
    JButton Delete_My_Account,edit,logout;
    String name12, phone12, email12, address12, gender12, occupation12;
    Connection connnect;
    String name22, phone22;
    JPanel delete_panel, edit_panel;

    public Account_details(String name22, String phone22) {
        this.phone22 = phone22;
        this.name22 = name22;
    }

    public void setpanel(JPanel panel_login,JPanel panel_account) {
        this.panel_login = panel_login;
        this.panel_account = panel_account;
    }

    public void Show_details(String name12, String phone12, String email12, String address12, String gender12, String occupation12) {
        this.name12 = name12;
        this.phone12 = phone12;
        this.email12 = email12;
        this.address12 = address12;
        this.gender12 = gender12;
        this.occupation12 = occupation12;

        delete_panel = new JPanel();
        delete_panel.setVisible(false);
        delete_panel.setBounds(65,420,370,160);
        delete_panel.setBackground(Color.yellow);
        delete_panel.setLayout(null);

        JLabel are_you_sure_delete = new JLabel("Are you sure you want to DELETE your account !");
        JButton confirm = new JButton("CONFIRM");
        JButton back_1 = new JButton("BACK");
        are_you_sure_delete.setBounds(57,20,320,50);
        confirm.setBounds(80,85,100,30);
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(Color.red);
        back_1.setBounds(190,85,100,30);
        back_1.setForeground(Color.WHITE);
        back_1.setBackground(Color.red);

        edit_panel = new JPanel();
        edit_panel.setVisible(false);
        edit_panel.setBounds(65,420,370,160);
        edit_panel.setBackground(Color.yellow);
        edit_panel.setLayout(null);

        JLabel are_you_sure_update = new JLabel("Are you sure you want to UPDATE your account !");
        JButton update = new JButton("UPDATE");
        are_you_sure_update.setBounds(57,20,320,50);
        update.setBounds(80,85,100,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.red);
        JButton back_2 = new JButton("BACK");
        back_2.setBounds(190,85,100,30);
        back_2.setForeground(Color.WHITE);
        back_2.setBackground(Color.red);

        title = new JLabel("ACCOUNT DETAILS");
        title.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        title.setForeground(Color.BLUE);

        name = new JLabel("Name : ");
        phone = new JLabel("Phone : ");
        email = new JLabel("Email : ");
        address = new JLabel("Address : ");
        gender = new JLabel("Gender : ");
        occupation = new JLabel("Occupation : ");
        Delete_My_Account = new JButton("Delete Account");
        edit = new JButton("EDIT");
        logout = new JButton("LOGOUT");
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.red);

        Your_name = new JTextField(name12);
        Your_name.setEditable(false);
        Your_phone = new JTextField(phone12);
        Your_phone.setEditable(false);
        Your_email = new JTextField(email12);
        Your_email.setEditable(false);
        Your_address = new JTextField(address12);
        Your_address.setEditable(false);
        Your_gender = new JTextField(gender12);
        Your_gender.setEditable(false);
        Your_occupation = new JTextField(occupation12);
        Your_occupation.setEditable(false);

        title.setBounds(150, 10, 300, 30);
        name.setBounds(70, 50, 80, 30);
        phone.setBounds(70, 100, 80, 30);
        email.setBounds(70, 150, 80, 30);
        address.setBounds(70, 200, 80, 30);
        gender.setBounds(70, 270, 80, 30);
        occupation.setBounds(70, 320, 80, 30);
        edit.setBounds(300,370,100,30);
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);
        Delete_My_Account.setBounds(80, 370, 200, 30);
        Delete_My_Account.setBackground(Color.BLACK);
        Delete_My_Account.setForeground(Color.WHITE);
        logout.setBounds(440,5,95,27);

        Your_name.setBounds(155, 50, 250, 30);
        Your_phone.setBounds(155, 100, 250, 30);
        Your_email.setBounds(155, 150, 250, 30);
        Your_address.setBounds(155, 200, 250, 50);
        Your_gender.setBounds(155, 270, 250, 30);
        Your_occupation.setBounds(155, 320, 250, 30);

        jdbc jb1 = new jdbc();
        connnect = jb1.giveConnection();
        confirm.addActionListener(new After_confirm());
        update.addActionListener(new After_update());
        Delete_My_Account.addActionListener(new After_delete());
        edit.addActionListener(new After_edit());
        After_back bck = new After_back();
        back_1.addActionListener(bck);
        back_2.addActionListener(bck);
        logout.addActionListener(new After_logout());

        panel_account.add(title);
        panel_account.add(name);
        panel_account.add(phone);
        panel_account.add(email);
        panel_account.add(address);
        panel_account.add(gender);
        panel_account.add(occupation);
        panel_account.add(Delete_My_Account);
        panel_account.add(edit);
        panel_account.add(logout);

        panel_account.add(Your_name);
        panel_account.add(Your_phone);
        panel_account.add(Your_email);
        panel_account.add(Your_address);
        panel_account.add(Your_gender);
        panel_account.add(Your_occupation);
        delete_panel.add(are_you_sure_delete);
        delete_panel.add(confirm);
        delete_panel.add(back_1);
        panel_account.add(delete_panel);
        edit_panel.add(are_you_sure_update);
        edit_panel.add(update);
        edit_panel.add(back_2);
        panel_account.add(edit_panel);

    }

    class After_delete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            edit_panel.setEnabled(false);
            edit_panel.setVisible(false);
            delete_panel.setEnabled(true);
            delete_panel.setVisible(true);
            Your_name.setEditable(false);
            Your_phone.setEditable(false);
            Your_email.setEditable(false);
            Your_address.setEditable(false);
            Your_gender.setEditable(false);
            Your_occupation.setEditable(false);
        }
    }

    class  After_confirm implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String Your_name_0 = (String) Your_name.getText();
            String Your_phone_0 = (String) Your_phone.getText();
            System.out.println( "name : " + Your_name_0 +"phone : "+ Your_phone_0 +", Will be deleted Successfully");
            jdbc_delete de = new jdbc_delete(connnect, Your_name_0, Your_phone_0);
            de.delete_account();
            JOptionPane.showMessageDialog(panel_login, "Your Account name : " + name22 + ", phone : " + phone22 + " Is Succsfully DELETED");
            delete_panel.setEnabled(false);
            delete_panel.setVisible(false);

            Start hmp = new Start();
            hmp.visibility_of_accounts_panel=false;
            panel_account.setVisible(hmp.visibility_of_accounts_panel);
            System.out.println("visibility_of_accounts_panel at After_logout :" + hmp.visibility_of_accounts_panel);
            Start.checking_login_or_logout=2;
            System.out.println("Start.checking_login_or_logout at after_logout : "+ Start.checking_login_or_logout);
            panel_login.setVisible(true);
        }
    }

    class After_edit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            delete_panel.setEnabled(false);
            delete_panel.setVisible(false);
            edit_panel.setEnabled(true);
            edit_panel.setVisible(true);

            Your_name.setEditable(true);
            Your_phone.setEditable(true);
            Your_email.setEditable(true);
            Your_address.setEditable(true);
            Your_gender.setEditable(true);
            Your_occupation.setEditable(true);
        }
    }

    class After_update implements ActionListener{

        jdbc_update update_now = new jdbc_update();
        @Override
        public void actionPerformed(ActionEvent e) {
            String Your_name2 = (String) Your_name.getText();
            String Your_phone2 = (String) Your_phone.getText();
            String Your_email2 = (String) Your_email.getText();
            String Your_address2 = (String) Your_address.getText();
            String Your_gender2 = (String) Your_gender.getText();
            String Your_occupation2 = (String) Your_occupation.getText();

            update_now.update_from_this(connnect,name22,phone22);
            update_now.updated_values(Your_name2,Your_phone2,Your_email2,Your_address2, Your_gender2,Your_occupation2);
            update_now.update();

            JOptionPane.showMessageDialog(panel_login,"Your Data Updated Successfully !");
            edit_panel.setEnabled(false);
            edit_panel.setVisible(false);
        }
    }

    class After_back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            delete_panel.setEnabled(false);
            delete_panel.setVisible(false);
            edit_panel.setEnabled(false);
            edit_panel.setVisible(false);
        }
    }

    class After_logout implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(panel_account,"Are you sure for logout ?");
            System.out.println("logging out");

            Start hmp = new Start();
            hmp.visibility_of_accounts_panel=false;
            panel_account.setVisible(hmp.visibility_of_accounts_panel);
            System.out.println("visibility_of_accounts_panel at After_logout :" + hmp.visibility_of_accounts_panel);
            Start.checking_login_or_logout=2;
            System.out.println("Start.checking_login_or_logout at after_logout : "+ Start.checking_login_or_logout);

            panel_login.setVisible(true);


        }
    }
}
