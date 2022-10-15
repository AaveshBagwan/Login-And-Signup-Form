import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {

    JFrame home_page;
    JMenu menu;
    JMenuBar menubar;
    JMenuItem home, login, signup;
    JPanel login_panel,home_panel,sign_up_panel,for_account_details_and_signup_panel ;
    JLabel welcome1;
    boolean visibility_of_accounts_panel;
    static int checking_login_or_logout;



    public void create_menu() {

        home_page = new JFrame("Home page");
        System.out.println("frame created");
        menu = new JMenu("Menu");
        menubar = new JMenuBar();
        home = new JMenuItem("Home");
        login = new JMenuItem("LogIn");
        signup = new JMenuItem("SignUp");

        welcome1 = new JLabel(" WELCOME TO THE SYSTEM ");
        welcome1.setBounds(250,185,700,300);
        welcome1.setForeground(Color.yellow);
        Font ft1 = new Font("TIMES NEW ROMAN", Font.BOLD, 40);
        welcome1.setFont(ft1);

        home_page.setSize(1100, 725);
        home_page.setVisible(true);
        home_page.setLayout(null);
        home_page.setResizable(false);
        home_page.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        login_panel = new JPanel();
        login_panel.setBounds(275,137,540, 350);
        login_panel.setBackground(Color.WHITE);
        login_panel.setLayout(null);
        login_panel.setVisible(false);

        for_account_details_and_signup_panel = new JPanel();
        for_account_details_and_signup_panel.setBounds(542,0,550,725);
        for_account_details_and_signup_panel.setVisible(false);
        for_account_details_and_signup_panel.setBackground(Color.WHITE);
        for_account_details_and_signup_panel.setLayout(null);

        home_panel = new JPanel();
        home_panel.setBounds(0,0,1100,725);
        home_panel.setLayout(null);
        home_panel.setVisible(false);
        home_panel.setBackground(Color.black);
        home_panel.add(welcome1);
//        welcome1 = new JLabel("HOME PANEL");
//        welcome1.setBounds(185,270,300,100);
//        welcome1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
//        welcome1.setForeground(Color.red);

        sign_up_panel = new JPanel();
        sign_up_panel.setBounds(275,0,550,700);
        sign_up_panel.setLayout(null);
        sign_up_panel.setBackground(Color.WHITE);
        sign_up_panel.setVisible(false);

        home.addActionListener(new after_home());
        login.addActionListener(new after_login());
        signup.addActionListener(new after_signup());

        menu.add(home);
        menu.add(login);
        menu.add(signup);
        menubar.add(menu);
        home_page.setJMenuBar(menubar);
        System.out.println("menu bar added");
//        home_panel.add(welcome1);
        home_page.getContentPane().add(login_panel);
        home_page.getContentPane().add(home_panel);
        home_page.getContentPane().add(sign_up_panel);
        home_page.getContentPane().add(for_account_details_and_signup_panel);
    }

    public static void main(String arg[]) {
        Start hmp = new Start();
        hmp.create_menu();
    }

    class after_home implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Into The home page");
            home_panel.setVisible(true);
            sign_up_panel.setVisible(false);
            login_panel.setVisible(false);
            visibility_of_accounts_panel=false;
            for_account_details_and_signup_panel.setVisible(false);
            System.out.println("checking_login_or_logout at after_home : "+ checking_login_or_logout);

            if(checking_login_or_logout==1){
                visibility_of_accounts_panel=true;
            }else if(checking_login_or_logout==2){
                visibility_of_accounts_panel=false;
            }else{
                visibility_of_accounts_panel=false;
            }

            System.out.println("visibility_of_accounts_panel at after_home :"+visibility_of_accounts_panel);

        }
    }

    class after_login implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Into The login page");
            home_panel.setVisible(false);
            sign_up_panel.setVisible(false);

            Login_form lf1 = new Login_form();
            lf1.create_login_page(login_panel,for_account_details_and_signup_panel);
            System.out.println("visibility_of_accounts_panel at after_login :"+visibility_of_accounts_panel);

            if(visibility_of_accounts_panel==true){
                login_panel.setVisible(false);
                for_account_details_and_signup_panel.setVisible(visibility_of_accounts_panel);
            }else{
                login_panel.setVisible(true);
                for_account_details_and_signup_panel.setVisible(visibility_of_accounts_panel);
            }
        }
    }

    class after_signup implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Into The sign page");
            Signup_form awtp1 = new Signup_form(sign_up_panel);
            home_panel.setVisible(false);
            sign_up_panel.setVisible(true);
            login_panel.setVisible(false);
            visibility_of_accounts_panel=false;
            for_account_details_and_signup_panel.setVisible(false);
            System.out.println("checking_login_or_logout at after_signup : "+ checking_login_or_logout);

            if(checking_login_or_logout==1){
                visibility_of_accounts_panel=true;
            }else if(checking_login_or_logout==2){
                visibility_of_accounts_panel=false;
            }else{
                visibility_of_accounts_panel=false;
            }

            System.out.println("visibility_of_accounts_panel at after_signup :"+visibility_of_accounts_panel);

        }
    }
}

