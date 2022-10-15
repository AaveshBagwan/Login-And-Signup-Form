import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup_form extends JPanel {

    JPanel f;
    JLabel name, email, Gender, Address, Phone, Occupation,title,enter;
    JButton Submit, clear;
    JTextField name_tf, email_tf, Phone_tf, enter_occupation;
    JRadioButton Male_button, Female_button, others_button;
    ButtonGroup bg1;
    JTextArea Address_ta1;
    JComboBox occupation_cb;

    String student = "Student";
    String goverment_job = "Goverment Sector Job";
    String private_job = "Private Sector Job";
    String housewife = "Housewife";
    String farmer = "Farmer";
    String others = "Others";
    String none = "None";


    public Signup_form(JPanel f) {
        this.f = f;
        title = new JLabel("SIGN-UP PAGE");
        Font ft = new Font("TIMES NEW ROMAN", Font.BOLD, 20);
        title.setFont(ft);
        title.setForeground(Color.blue);
        name = new JLabel("Name : ");
        email = new JLabel("Email Address : ");
        Gender = new JLabel("Gender : ");
        Address = new JLabel("Address : ");
        Phone = new JLabel("Phone Number : ");
        Occupation = new JLabel("Occupation : ");
        enter = new JLabel();
        Submit = new JButton("SUBMIT");
        Submit.setBackground(Color.BLUE);
        Submit.setForeground(Color.WHITE);
        clear = new JButton("CLEAR");
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);
        name_tf = new JTextField();
        email_tf = new JTextField();
        Phone_tf = new JTextField();
        enter_occupation = new JTextField();
        enter_occupation.setVisible(false);
        System.out.println("textfield : " + "false");


        Male_button = new JRadioButton("Male");
        Male_button.setActionCommand("Male");
        Female_button = new JRadioButton("Female");
        Female_button.setActionCommand("Female");
        others_button = new JRadioButton("Others");
        others_button.setActionCommand("Others");

        bg1 = new ButtonGroup();
        bg1.add(Male_button);
        bg1.add(Female_button);
        bg1.add(others_button);

        Address_ta1 = new JTextArea();

        occupation_cb = new JComboBox();
        occupation_cb.addItem(goverment_job);
        occupation_cb.addItem(private_job);
        occupation_cb.addItem(farmer);
        occupation_cb.addItem(housewife);
        occupation_cb.addItem(student);
        occupation_cb.addItem(others);
        occupation_cb.addItem(none);
        occupation_cb.setSelectedItem(null);


        name.setBounds(100, 50, 100, 30);
        email.setBounds(100, 100, 100, 30);
        Phone.setBounds(100, 150, 100, 30);
        name_tf.setBounds(200, 50, 200, 30);
        email_tf.setBounds(200, 100, 200, 30);
        Phone_tf.setBounds(200, 150, 200, 30);
        Address.setBounds(100, 200, 100, 30);
        Address_ta1.setBounds(200, 200, 200, 100);
        Gender.setBounds(100, 320, 100, 30);
        Male_button.setBounds(200, 320, 100, 30);
        Female_button.setBounds(200, 355, 100, 30);
        others_button.setBounds(200, 390, 100, 30);
        Occupation.setBounds(100, 440, 100, 30);
        occupation_cb.setBounds(200, 440, 200, 30);
        Submit.setBounds(130, 550, 120, 30);
        clear.setBounds(280, 550, 120, 30);
        title.setBounds(190, 12 , 300, 20);
        enter.setBounds(100,490,100,30);
        enter_occupation.setBounds(200,490,200,30);




        Submit.addActionListener(new jAfter_Submit());
        clear.addActionListener(new jAfter_Clear());
        occupation_cb.addItemListener(new After_others());

        f.add(name);
        f.add(email);
        f.add(Gender);
        f.add(Address);
        f.add(Phone);
        f.add(Address_ta1);
        f.add(Occupation);
        f.add(Male_button);
        f.add(Female_button);
        f.add(others_button);
        f.add(Submit);
        f.add(clear);
        f.add(name_tf);
        f.add(email_tf);
        f.add(Phone_tf);
        f.add(occupation_cb);
        f.add(title);
        f.add(enter);
        f.add(enter_occupation);




    }




    class jAfter_Submit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                jdbc jdbc1 = new jdbc();
                Connection con1 =  jdbc1.giveConnection();
                System.out.println("connection established succesfuly ");

                String name = name_tf.getText();
                System.out.println("name : "+name);

                String email = email_tf.getText();
                System.out.println("email : "+email);

                String Address = Address_ta1.getText();
                System.out.println("Address : "+Address);

                String Phone = Phone_tf.getText();
                System.out.println("Phone : "+Phone);

                String bg = String.valueOf(bg1.getSelection().getActionCommand());
                System.out.println("gender :"+bg );

                String occupation = (String) occupation_cb.getSelectedItem();
                if(occupation == others){
                    occupation = enter_occupation.getText();
                }
                System.out.println("occupation : "+ occupation);
                jdbc_add add = new jdbc_add(con1,name,email,Address,Phone,bg,occupation);

            }catch (Exception e1) {
                e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(f, "Your Information Succesfullly Submitted");


        }
    }

    class jAfter_Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            name_tf.setText(null);
            email_tf.setText(null);
            Phone_tf.setText(null);
            Address_ta1.setText(null);
            bg1.clearSelection();
            enter.setText(null);
            enter_occupation.setText("");
            enter_occupation.setEnabled(false);
            enter_occupation.setVisible(false);
            System.out.println("textfield : " + "false");
            occupation_cb.setSelectedItem(null);



        }
    }

    class After_others implements ItemListener{


        @Override
        public void itemStateChanged(ItemEvent e) {

            String occupation2 = (String) occupation_cb.getSelectedItem();
            System.out.println("occupation : "+occupation2);

            if(occupation2 == others){

                enter.setText("Enter :");
                enter_occupation.setText("");
                enter_occupation.setEnabled(true);
                enter_occupation.setText("");
                enter_occupation.setVisible(true);
                System.out.println("textfield : " + "true");

            }
            else{
                enter.setText(null);
                enter_occupation.setEnabled(false);
                enter_occupation.setVisible(false);
                System.out.println("textfield : " + "false");

            }
        }
    }
}

