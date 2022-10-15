import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_form {
    JPanel panel_account,for_signup,panel_login;
    JLabel phone_lf, name_lf, labell, title,note;
    JTextField phone_lf_tf,name_lf_tf;
    JButton log_in, clear;
    String name10;
    String phone10;
    int j=0;

    public void create_login_page (JPanel panel_login,JPanel panel_account) {
        this.panel_account = panel_account;
        this.panel_login = panel_login;

        note = new JLabel("Note: Please make sure to press CLEAR before LOGIN to avoid bugs !");
        phone_lf = new JLabel("Phone Number : ");
        name_lf = new JLabel("Name :");
        labell = new JLabel("Note : New user Signup First !");
        title = new JLabel("LOG-IN FORM");
        phone_lf_tf = new JTextField();
        name_lf_tf = new JTextField();
        log_in = new JButton("LOGIN");
        clear = new JButton("CLEAR");
        Font f = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
        title = new JLabel("LOGIN PAGE");
        title.setForeground(Color.BLUE);
        title.setFont(f);

        for_signup = new JPanel();
        for_signup.setVisible(true);
        for_signup.setSize(550,700);
        for_signup.setLayout(null);

        name_lf.setBounds(100, 80, 100, 30);
        name_lf_tf.setBounds(220, 80, 200, 30);
        phone_lf.setBounds(100, 130, 100, 30);
        phone_lf_tf.setBounds(220, 130, 200, 30);
        log_in.setBounds(140, 230, 100, 30);
        log_in.setForeground(Color.WHITE);
        log_in.setBackground(Color.red);
        labell.setBounds(190, 180, 200, 30);
        clear.setBounds(280,230,100,30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.blue);
        note.setBounds(70,275,400,30);
        title.setBounds(180, 20, 200, 30);

        log_in.addActionListener(new After_login());
        clear.addActionListener(new after_clear());

        panel_login.add(name_lf);
        panel_login.add(name_lf_tf);
        panel_login.add(phone_lf);
        panel_login.add(phone_lf_tf);
        panel_login.add(log_in);
        panel_login.add(labell);
        panel_login.add(title);
        panel_login.add(clear);
        panel_login.add(note);
    }


    class After_login implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            phone10 = (String) phone_lf_tf.getText();
            System.out.println("you have entered in phone field : "+phone10);

            name10 = (String) name_lf_tf.getText();
            System.out.println("you have entered in name field : "+name10);

            try {
                jdbc_select select = new jdbc_select(name10,phone10);
                int i1 = select.check();
                if(i1!=0){
                    String name11 = select.getYour_name1();
                    String phone11 = select.getYour_phone1();
                    String email11 = select.getYour_email1();
                    String address11 = select.getYour_address1();
                    String gender11 = select.getYour_gender1();
                    String occupation11 = select.getYour_occupation1();
                    if(j==0){
                        Start hmp = new Start();
                        hmp.visibility_of_accounts_panel=true;
                        panel_account.setVisible(hmp.visibility_of_accounts_panel);
                        System.out.println("visibility_of_accounts_panel at After_login :" + hmp.visibility_of_accounts_panel);
                        panel_login.setVisible(false);
                        Account_details details = new Account_details(name10,phone10);
                        details.setpanel(panel_login,panel_account);
                        details.Show_details(name11,phone11,email11,address11,gender11,occupation11);
                        Start.checking_login_or_logout=1;
                        System.out.println("Start.checking_login_or_logout at after_login: " + Start.checking_login_or_logout);
                    }
                    j++;
                }
                else{
                    JOptionPane.showMessageDialog(panel_account,"Your Not Registered Please SignUp First !");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }

    class after_clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            phone_lf_tf.setText(null);
            name_lf_tf.setText(null);
            j = 0;
        }
    }
}
